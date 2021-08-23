package br.com.zup.ZupAgenda.repositories;

import br.com.zup.ZupAgenda.models.Contato;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {
}
