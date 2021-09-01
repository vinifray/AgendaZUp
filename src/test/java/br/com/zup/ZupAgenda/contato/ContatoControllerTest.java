package br.com.zup.ZupAgenda.contato;

import br.com.zup.ZupAgenda.contato.dtos.CadastroContatoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//WebMvcTest é a anotação para realização de teste de controller, para ele precisa receber como parametro a classe que será testada
@WebMvcTest(ContatoController.class)
public class ContatoControllerTest {
    @MockBean
    private ContatoService contatoService;

    //MockMvc é a classe responsavel por simular requisoções HTTP no endpoint do controller
    @Autowired
    private MockMvc mockMvc;

    private CadastroContatoDTO contatoDTO;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        contatoDTO = new CadastroContatoDTO();
        contatoDTO.setEmail("marvin@dontpanic.com");
        contatoDTO.setTelefone("42 99777878");
        contatoDTO.setNome("Marvin");

        objectMapper = new ObjectMapper();
    }


    @Test
    public void testarRotaDeCadastroDeContatoCaminhoPositivo() throws Exception {
        Mockito.when(contatoService.salvarContato(Mockito.any(Contato.class)))
                .thenReturn(contatoDTO.converterDTOemContato());
        String json = objectMapper.writeValueAsString(contatoDTO);

        ResultActions resultadoDaRequisicao = mockMvc
                .perform(MockMvcRequestBuilders.post("/contatos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email",
                        CoreMatchers.equalTo(contatoDTO.getEmail())));

        String jsonResposta = resultadoDaRequisicao.andReturn().getResponse().getContentAsString();
        Contato contato = objectMapper.readValue(jsonResposta, Contato.class);
    }

    @Test
    public void testarValidacaoDeCadastroContato() throws Exception {
        Mockito.when(contatoService.salvarContato(Mockito.any(Contato.class)))
                .thenReturn(contatoDTO.converterDTOemContato());
        contatoDTO.setEmail("asuihdia");
        contatoDTO.setNome("A");
        String json = objectMapper.writeValueAsString(contatoDTO);

        ResultActions resultadoDaRequisicao = mockMvc
                .perform(MockMvcRequestBuilders.post("/contatos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testarBuscaDeContatoPorId() throws Exception{
        Mockito.when(contatoService.buscarContatoPeloId(Mockito.anyInt()))
                .thenReturn(contatoDTO.converterDTOemContato());

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/contatos/42")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

        String jsonDeResposta = resultActions.andReturn().getResponse().getContentAsString();
        Contato contato = objectMapper.readValue(jsonDeResposta, Contato.class);

    }

    @Test
    public void testarBucaDeContatoPeloIdNaoExiste() throws Exception {
        Mockito.when(contatoService.buscarContatoPeloId(Mockito.anyInt()))
                .thenThrow(RuntimeException.class);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/contatos/42")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
