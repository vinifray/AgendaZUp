package br.com.zup.ZupAgenda.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PutMapping("/{idContato}")
    public Endereco cadastrarEndereco(@RequestBody Endereco endereco, @PathVariable int idContato) {
        return enderecoService.cadastrarEndereço(idContato, endereco);
    }
}
