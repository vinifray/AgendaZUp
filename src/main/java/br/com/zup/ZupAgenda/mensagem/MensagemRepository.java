package br.com.zup.ZupAgenda.mensagem;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MensagemRepository extends CrudRepository<Mensagem, Integer> {
    List<Mensagem> findAllByVisualizado(boolean visualizado);
    List<Mensagem> findAllByContatoNomeContains(String nome);
}
