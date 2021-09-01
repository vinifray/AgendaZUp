package br.com.zup.ZupAgenda.endereco;

import br.com.zup.ZupAgenda.contato.Contato;
import br.com.zup.ZupAgenda.contato.ContatoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class EnderecoServiceTest {
    @Autowired
    private EnderecoService enderecoService;

    @MockBean
    private EnderecoRepository enderecoRepository;
    @MockBean
    private ContatoService contatoService;

    private Endereco endereco;
    private Contato contato;

    @BeforeEach
    public void setUp(){
        endereco = new Endereco();
        contato = new Contato();
    }

    @Test
    public void testarCadastroDeEnderecoCaminhoPositivo(){
        Mockito.when(contatoService.contatoExistente(Mockito.anyInt())).thenReturn(true);
        Mockito.when(contatoService.buscarContatoPeloId(Mockito.anyInt())).thenReturn(contato);
        Mockito.when(contatoService.salvarContato(Mockito.any(Contato.class))).thenReturn(contato);
        Mockito.when(enderecoRepository.save(Mockito.any(Endereco.class))).thenReturn(endereco);

        Endereco objetoDeTeste = enderecoService.cadastrarEndereço(12, endereco);

        Assertions.assertEquals(contato.getEndereco(), objetoDeTeste);
        // Mockito verify testa quantas vezes o metodo foi chamado
        Mockito.verify(contatoService, Mockito.times(1)).salvarContato(contato);
    }
}
