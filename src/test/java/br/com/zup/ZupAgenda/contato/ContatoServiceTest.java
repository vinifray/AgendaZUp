package br.com.zup.ZupAgenda.contato;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ContatoServiceTest {
    @Autowired
    private ContatoService contatoService;

    @MockBean
    private ContatoRepository contatoRepository;

    @Test
    public void testarMetodoSalvarContatoCaminhoPositivo(){
        Contato contato = new Contato();
        Mockito.when(contatoRepository.save(Mockito.any(Contato.class)))
                .thenReturn(contato);

        Contato objetoDeTeste = contatoService.salvarContato(contato);
        Assertions.assertEquals(contato, objetoDeTeste);
    }


}
