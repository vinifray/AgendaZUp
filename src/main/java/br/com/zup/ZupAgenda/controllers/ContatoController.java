package br.com.zup.ZupAgenda.controllers;

import br.com.zup.ZupAgenda.dtos.CadastroContatoDTO;
import br.com.zup.ZupAgenda.models.Contato;
import br.com.zup.ZupAgenda.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Contato cadastrarContato(@RequestBody @Valid CadastroContatoDTO contato){
        Contato contatoModel = contato.converterDTOemContato();
        return contatoService.cadastrarContato(contatoModel);
    }
}
