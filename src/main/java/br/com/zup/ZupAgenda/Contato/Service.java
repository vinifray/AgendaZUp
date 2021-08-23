package br.com.zup.ZupAgenda.Contato;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository;

    public Contato salvarContato(Contato contato){
        return repository.save(contato);
    }

    public List<Contato> exibirTodosOsContatos(){
        return (List<Contato>) repository.findAll();
    }

    public List<Contato> exibirTodosOsContatos(String letra){
        return repository.findByNomeStartsWithIgnoreCase(letra);
    }

    public boolean contatoExistente(int id) {
        return repository.existsById(id);
    }

    public Contato buscarContatoPeloId(int id){
        Optional<Contato> contatoOptional = repository.findById(id);

        if(contatoOptional.isPresent()){
            return contatoOptional.get();
        }
        throw new RuntimeException("Contato não encontrado");

    }

    public void deletarPorID(int id){
        repository.deleteById(id);
    }


}
