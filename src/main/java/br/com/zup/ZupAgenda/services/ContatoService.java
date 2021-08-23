package br.com.zup.ZupAgenda.services;

import br.com.zup.ZupAgenda.models.Contato;
import br.com.zup.ZupAgenda.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public Contato salvarContato(Contato contato){
        return contatoRepository.save(contato);
    }

    public List<Contato> exibirTodosOsContatos(){
        return (List<Contato>) contatoRepository.findAll();
    }

    public List<Contato> exibirTodosOsContatos(String letra){
        return contatoRepository.findByNomeStartsWithIgnoreCase(letra);
    }

    public boolean contatoExistente(int id){
        return contatoRepository.existsById(id);
    }

    public Contato buscarContatoPeloId(int id){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if(contatoOptional.isPresent()){
            return contatoOptional.get();
        }
        throw new RuntimeException("Contato não encontrado");

    }

    public void deletarPorID(int id){
        contatoRepository.deleteById(id);
    }


}
