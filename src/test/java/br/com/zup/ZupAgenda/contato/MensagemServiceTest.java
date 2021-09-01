package br.com.zup.ZupAgenda.contato;

import br.com.zup.ZupAgenda.mensagem.MensagemRepository;
import br.com.zup.ZupAgenda.mensagem.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MensagemServiceTest {
    @Autowired
    private MensagemService mensagemService;

    @MockBean
    private ContatoService contatoService;
    @MockBean
    private MensagemRepository mensagemRepository;



}
