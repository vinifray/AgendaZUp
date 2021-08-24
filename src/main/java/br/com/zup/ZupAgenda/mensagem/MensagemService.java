package br.com.zup.ZupAgenda.mensagem;

import br.com.zup.ZupAgenda.contato.Contato;
import br.com.zup.ZupAgenda.contato.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
}
