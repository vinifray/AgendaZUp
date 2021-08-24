package br.com.zup.ZupAgenda.Contato.dtos;

import br.com.zup.ZupAgenda.Contato.Contato;

import java.util.List;
import java.util.stream.Collectors;

public class ContatoResumidoDTO {

    private int id;
    private String nome;
    private String telefone;

    public ContatoResumidoDTO() {
    }

    public ContatoResumidoDTO(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static List<ContatoResumidoDTO> converterListaDeModelParaDTO(List<Contato> contatos){
        return contatos.stream()
                .map(contato -> new ContatoResumidoDTO(
                        contato.getId(),
                        contato.getNome(),
                        contato.getTelefone())
                ).collect(Collectors.toList());
    }
}
