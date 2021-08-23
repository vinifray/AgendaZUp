package br.com.zup.ZupAgenda.controllers;

import br.com.zup.ZupAgenda.dtos.AtualizarContatoDTO;
import br.com.zup.ZupAgenda.dtos.CadastroContatoDTO;
import br.com.zup.ZupAgenda.models.Contato;
import br.com.zup.ZupAgenda.services.ContatoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Contato cadastrarContato(@RequestBody @Valid CadastroContatoDTO contato){
        Contato contatoModel = contato.converterDTOemContato();
        return contatoService.salvarContato(contatoModel);
    }

    @GetMapping
    public List<Contato> visualizarContatos(@RequestParam(required = false) String letra){
        if(letra != null){
            return contatoService.exibirTodosOsContatos(letra);
        }
        return contatoService.exibirTodosOsContatos();
    }

    @GetMapping("/{qualquerCoisa}")
    public Contato pesquisarContatoPorId(@PathVariable(name = "qualquerCoisa") int id){
        Contato contato;

        try{
            contato = contatoService.buscarContatoPeloId(id);
            return contato;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping
    public Contato atualizarContato(@RequestBody @Valid AtualizarContatoDTO atualizarContatoDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        Contato objetoConvertido = objectMapper.convertValue(atualizarContatoDTO, Contato.class);

        if(!contatoService.contatoExistente(objetoConvertido.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contato não encontrado");
        }
        return contatoService.salvarContato(objetoConvertido);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPeloID(@PathVariable int id){
        contatoService.deletarPorID(id);
    }

}
