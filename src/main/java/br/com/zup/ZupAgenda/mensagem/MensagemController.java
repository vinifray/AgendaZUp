package br.com.zup.ZupAgenda.mensagem;

import br.com.zup.ZupAgenda.mensagem.dtos.CadastroMensagemDTO;
import br.com.zup.ZupAgenda.mensagem.dtos.MensagemDTO;
import br.com.zup.ZupAgenda.mensagem.dtos.MensagemIdDTO;
import br.com.zup.ZupAgenda.mensagem.dtos.ResumoMensagemDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
    @Autowired
    private MensagemService mensagemService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/{contatoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemDTO cadastrarMensagem(@RequestBody @Valid CadastroMensagemDTO mensagemDTO, @PathVariable int contatoId){
        Mensagem mensagem = mensagemDTO.converterDTOParaModel();
        mensagem = mensagemService.cadastrarMensagem(contatoId, mensagem);
        return MensagemDTO.converterModelParaDTO(mensagem);
    }

    @GetMapping("/{mensagemId}")
    public ResumoMensagemDTO visualizarMensagem(@PathVariable(name = "mensagemId") int id){
        //ModelMapper é uma classe responsavel por converter Models(Entity) em DTO e DTO em Model(entity)
        //ModelMapper só é acessivel caso a dependencia esteja no POM.XML.
        Mensagem mensagem = mensagemService.visualizarMensagemPorId(id);
        return modelMapper.map(mensagem, ResumoMensagemDTO.class);
    }

    @GetMapping
    public List<MensagemIdDTO> pesquisarMensagens(@RequestParam(required = false) String nomeContato,
                                             @RequestParam(required = false) Boolean visualizado){
        List<Mensagem> mensagens = mensagemService.filtrarMengensPor(nomeContato, visualizado);
        List<MensagemIdDTO> mensagemIdDTOS = mensagens.
                stream()
                .map(mensagem -> modelMapper.map(mensagem, MensagemIdDTO.class)).collect(Collectors.toList());
        return mensagemIdDTOS;
    }
}
