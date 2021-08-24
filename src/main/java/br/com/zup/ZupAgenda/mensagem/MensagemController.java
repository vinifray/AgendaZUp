package br.com.zup.ZupAgenda.mensagem;

import br.com.zup.ZupAgenda.mensagem.dtos.CadastroMensagemDTO;
import br.com.zup.ZupAgenda.mensagem.dtos.MensagemDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
    @Autowired
    private MensagemService mensagemService;

    @PostMapping("/{contatoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemDTO cadastrarMensagem(@RequestBody @Valid CadastroMensagemDTO mensagemDTO, @PathVariable int contatoId){
        Mensagem mensagem = mensagemDTO.converterDTOParaModel();
        mensagem = mensagemService.cadastrarMensagem(contatoId, mensagem);
        return MensagemDTO.converterModelParaDTO(mensagem);
    }
}
