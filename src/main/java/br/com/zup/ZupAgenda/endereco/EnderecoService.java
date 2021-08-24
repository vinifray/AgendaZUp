package br.com.zup.ZupAgenda.endereco;

import br.com.zup.ZupAgenda.contato.Contato;
import br.com.zup.ZupAgenda.contato.ContatoService;
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


    public Endereco cadastrarEndereço(int id, Endereco endereco){
        if (contatoService.contatoExistente(id)){
            Contato contatoObjeto = contatoService.buscarContatoPeloId(id);

            enderecoRepository.save(endereco);
            contatoObjeto.setEndereco(endereco);

            contatoService.salvarContato(contatoObjeto);
            return endereco;
        }

        throw new RuntimeException("Contato não encontrado");
    }
}
