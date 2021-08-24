package br.com.zup.ZupAgenda.mensagem;

import br.com.zup.ZupAgenda.mensagem.dtos.CadastroMensagemDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {


    @PostMapping("/{contatoId}")
    public Mensagem cadastrarMensagem(@RequestBody @Valid CadastroMensagemDTO mensagemDTO, @PathVariable int contatoId){
        Mensagem mensagem = mensagemDTO.converterDTOParaModel();
    }
}
