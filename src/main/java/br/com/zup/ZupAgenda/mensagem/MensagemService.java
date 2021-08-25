package br.com.zup.ZupAgenda.mensagem;

import br.com.zup.ZupAgenda.contato.Contato;
import br.com.zup.ZupAgenda.contato.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {
    private MensagemRepository mensagemRepository;
    private ContatoService contatoService;

    @Autowired
    public MensagemService(MensagemRepository mensagemRepository, ContatoService contatoService) {
        this.mensagemRepository = mensagemRepository;
        this.contatoService = contatoService;
    }

    public Mensagem cadastrarMensagem(int contatoId, Mensagem mensagem){
        Contato contato = contatoService.buscarContatoPeloId(contatoId);

        mensagem.setContato(contato);
        mensagem.setDataDeEnvio(LocalDate.now());
        mensagem.setVisualizado(false);

        return mensagemRepository.save(mensagem);
    }

    public Mensagem pesquisarMensagemPorId(int id){
        //Optional é um objeto que pode ou não ter a Mensagem dentro dele.
        //O Optional serve para retornar o Objeto do banco de dados ou o valor null e assim evitar NullPointerExceptional
        Optional<Mensagem> mensagemOptional = mensagemRepository.findById(id);

        if(mensagemOptional.isPresent()){
            return mensagemOptional.get();
        }
        throw new RuntimeException("Mensagem nao encontrada");
    }

    public Mensagem visualizarMensagemPorId(int id){
        Mensagem mensagem = pesquisarMensagemPorId(id);

        mensagem.setVisualizado(true);
        mensagemRepository.save(mensagem);
        return mensagem;
    }

    public List<Mensagem> filtrarMengensPor(String nomeContato, Boolean visualizado){
        if(nomeContato != null){
            return mensagemRepository.findAllByContatoNomeContains(nomeContato);
        }if(visualizado != null){
            return mensagemRepository.findAllByVisualizado(visualizado);
        }

        //(List<Mensagem>) é um casting para converter o Iterable do repository em uma lista
        return (List<Mensagem>) mensagemRepository.findAll();
    }
}
