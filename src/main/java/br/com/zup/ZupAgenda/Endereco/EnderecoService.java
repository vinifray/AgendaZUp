package br.com.zup.ZupAgenda.Endereco;

import br.com.zup.ZupAgenda.Contato.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;
    private ContatoService contatoService;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository, ContatoService contatoService) {
        this.enderecoRepository = enderecoRepository;
        this.contatoService = contatoService;
    }


}
