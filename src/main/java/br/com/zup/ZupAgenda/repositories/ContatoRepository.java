package br.com.zup.ZupAgenda.repositories;

import br.com.zup.ZupAgenda.models.Contato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {
    List<Contato> findByNomeStartsWithIgnoreCase(String letra);
}
