package br.com.zup.ZupAgenda.Contato;

import br.com.zup.ZupAgenda.Contato.Contato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repository extends CrudRepository<Contato, Integer> {
    List<Contato> findByNomeStartsWithIgnoreCase(String letras);
}
