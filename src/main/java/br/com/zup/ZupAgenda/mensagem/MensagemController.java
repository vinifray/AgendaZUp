package br.com.zup.ZupAgenda.mensagem;

import br.com.zup.ZupAgenda.mensagem.dtos.CadastroMensagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
    @Autowired
    private MensagemService mensagemService;

    @PostMapping("/{contatoId}")
    public Mensagem cadastrarMensagem(@RequestBody @Valid CadastroMensagemDTO mensagemDTO, @PathVariable int contatoId){
        Mensagem mensagem = mensagemDTO.converterDTOParaModel();
        return mensagemService.cadastrarMensagem(contatoId, mensagem);
    }
}
