package br.com.zup.ZupAgenda.contato;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {
    List<Contato> findByNomeStartsWithIgnoreCase(String letras);

    List<Contato> findByEnderecoLogradouroContains(String logradouro);
}
