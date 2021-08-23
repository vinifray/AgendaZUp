package br.com.zup.ZupAgenda.Contato.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AtualizarContatoDTO {
    @NotNull(message = "Id obrigatorio")
    private int id;
    @Size(message = "Minimo 2 letras", min = 2)
    private String nome;
    @Email(message = "Email fora do padrão")
    private String email;
    private String telefone;

    public AtualizarContatoDTO() {
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
}
