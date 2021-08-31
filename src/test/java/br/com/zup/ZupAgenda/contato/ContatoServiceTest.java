package br.com.zup.ZupAgenda.contato;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void testarMetodoBuscarContatoPorIDCaminhoPositivo(){
        Contato contato = new Contato();
        Optional<Contato> contatoOptional = Optional.of(contato);
        Mockito.when(contatoRepository.findById(Mockito.anyInt())).thenReturn(contatoOptional);

        Assertions.assertEquals(contato, contatoService.buscarContatoPeloId(12));
    }

    @Test
    public void testarMetodoBuscarContatoPorIDCaminhoNegativo(){
        Optional<Contato> contatoOptional = Optional.empty();
        Mockito.when(contatoRepository.findById(Mockito.anyInt())).thenReturn(contatoOptional);

        RuntimeException exception = Assertions
                .assertThrows(RuntimeException.class, () -> {contatoService.buscarContatoPeloId(21);});
        Assertions.assertTrue(exception.getMessage().equals("Contato não encontrado"));
    }
}
