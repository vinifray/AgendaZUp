package br.com.zup.ZupAgenda.Contato;

import br.com.zup.ZupAgenda.Contato.dtos.AtualizarContatoDTO;
import br.com.zup.ZupAgenda.Contato.dtos.CadastroContatoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class Controller {
    @Autowired
    private ContatoService service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Contato cadastrarContato(@RequestBody @Valid CadastroContatoDTO contato){
        Contato contatoModel = contato.converterDTOemContato();
        return service.salvarContato(contatoModel);
    }

    @GetMapping
    public List<Contato> visualizarContatos(@RequestParam(required = false) String letra){
        if(letra != null){
            return service.exibirTodosOsContatos(letra);
        }
        return service.exibirTodosOsContatos();
    }

    @GetMapping("/{qualquerCoisa}")
    public Contato pesquisarContatoPorId(@PathVariable(name = "qualquerCoisa") int id){
        Contato contato;

        try{
            contato = service.buscarContatoPeloId(id);
            return contato;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping
    public Contato atualizarContato(@RequestBody @Valid AtualizarContatoDTO atualizarContatoDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        Contato objetoConvertido = objectMapper.convertValue(atualizarContatoDTO, Contato.class);

        if(!service.contatoExistente(objetoConvertido.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contato não encontrado");
        }
        return service.salvarContato(objetoConvertido);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPeloID(@PathVariable int id){
        service.deletarPorID(id);
    }

}
