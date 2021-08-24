package br.com.zup.ZupAgenda.mensagem;

import br.com.zup.ZupAgenda.contato.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    private MensagemRepository mensagemRepository;
    private ContatoService contatoService;

    @Autowired
    public MensagemService(MensagemRepository mensagemRepository, ContatoService contatoService) {
        this.mensagemRepository = mensagemRepository;
        this.contatoService = contatoService;
    }


}
