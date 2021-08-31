package br.com.zup.ZupAgenda.contato;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testarMetodoExibirTodosOsContatosCaminhoPositivo(){
        Contato contato = new Contato();
        Iterable<Contato> contatoIterable = Arrays.asList(contato);
        Mockito.when(contatoRepository.findAll()).thenReturn(contatoIterable);

        Assertions.assertTrue(contatoService.exibirTodosOsContatos() instanceof List);
    }

    @Test
    public void testarMetodoExibirTodosOsContatosCaminhoPositivoBuscaPeloNome(){
        Contato contato = new Contato();
        List<Contato> contatoList= Arrays.asList(contato);
        Mockito.when(contatoRepository.findByNomeStartsWithIgnoreCase(Mockito.anyString()))
                .thenReturn(contatoList);

        Assertions.assertEquals(contatoList, contatoService.exibirTodosOsContatos("qualquercoisa"));
    }

}
