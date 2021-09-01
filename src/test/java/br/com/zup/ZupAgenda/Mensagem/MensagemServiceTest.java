package br.com.zup.ZupAgenda.Mensagem;

import br.com.zup.ZupAgenda.contato.Contato;
import br.com.zup.ZupAgenda.contato.ContatoService;
import br.com.zup.ZupAgenda.mensagem.Mensagem;
import br.com.zup.ZupAgenda.mensagem.MensagemRepository;
import br.com.zup.ZupAgenda.mensagem.MensagemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.PrimitiveIterator;

@SpringBootTest
public class MensagemServiceTest {
    @Autowired
    private MensagemService mensagemService;

    @MockBean
    private ContatoService contatoService;
    @MockBean
    private MensagemRepository mensagemRepository;

    private Contato contato;
    private Mensagem mensagem;

    @BeforeEach
    public void setUp(){
        contato = new Contato();
        mensagem = new Mensagem();
        mensagem.setMensagem("Adeus e obrigo pelos peixes");
    }

    @Test
    public void testarCadastroDeMesagemCaminhoPositivo(){
        Mockito.when(contatoService.buscarContatoPeloId(Mockito.anyInt())).thenReturn(contato);
        Mockito.when(mensagemRepository.save(Mockito.any(Mensagem.class))).thenReturn(mensagem);

        Mensagem objetoDeTeste = mensagemService.cadastrarMensagem(42, mensagem);

        Assertions.assertEquals(mensagem, objetoDeTeste);
        Assertions.assertEquals(contato, objetoDeTeste.getContato());
        Assertions.assertEquals(LocalDate.now(), objetoDeTeste.getDataDeEnvio());
        Assertions.assertFalse(objetoDeTeste.isVisualizado());
        Assertions.assertEquals("Adeus e obrigo pelos peixes", objetoDeTeste.getMensagem());
    }


}
