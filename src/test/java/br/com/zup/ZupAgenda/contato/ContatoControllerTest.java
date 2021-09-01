package br.com.zup.ZupAgenda.contato;

import br.com.zup.ZupAgenda.contato.dtos.CadastroContatoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

//WebMvcTest é a anotação para realização de teste de controller, para ele precisa receber como parametro a classe que será testada
@WebMvcTest(ContatoController.class)
public class ContatoControllerTest {
    @MockBean
    private ContatoService contatoService;

    //MockMvc é a classe responsavel por simular requisoções HTTP no endpoint do controller
    @Autowired
    private MockMvc mockMvc;

    private CadastroContatoDTO contatoDTO;

    @BeforeEach
    public void setUp(){
        contatoDTO = new CadastroContatoDTO();
        contatoDTO.setEmail("marvin@dontpanic.com");
        contatoDTO.setTelefone("42 99777878");
        contatoDTO.setNome("Marvin");
    }

}
