package br.com.zup.ZupAgenda.contato.dtos;

import br.com.zup.ZupAgenda.contato.Contato;

import javax.persistence.Column;

public class ContatoDTO {
    private int id;
    private String nome;
    private String email;
    private String telefone;

    public ContatoDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static ContatoDTO converterModelParaDTO(Contato contato){
        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setEmail(contato.getEmail());
        contatoDTO.setNome(contato.getNome());
        contatoDTO.setTelefone(contato.getTelefone());
        contatoDTO.setId(contato.getId());

        return contatoDTO;
    }
}
