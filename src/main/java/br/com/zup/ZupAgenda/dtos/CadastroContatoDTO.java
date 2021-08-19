package br.com.zup.ZupAgenda.dtos;


import br.com.zup.ZupAgenda.models.Contato;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class CadastroContatoDTO {
    @Size(message = "Minimo 2 letras", min = 2)
    private String nome;
    @Email(message = "Email fora do padrão")
    private String email;
    private String telefone;

    public CadastroContatoDTO() {
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

    public Contato converterDTOemContato(){
        Contato contato = new Contato();
        contato.setEmail(email);
        contato.setNome(nome);
        contato.setTelefone(telefone);

        return contato;
    }
}
