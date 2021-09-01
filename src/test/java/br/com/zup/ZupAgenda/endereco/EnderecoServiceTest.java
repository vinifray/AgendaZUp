package br.com.zup.ZupAgenda.endereco;

import br.com.zup.ZupAgenda.contato.Contato;
import br.com.zup.ZupAgenda.contato.ContatoService;
import org.junit.jupiter.api.BeforeEach;
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
}
