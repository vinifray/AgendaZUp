package br.com.zup.ZupAgenda.mensagem.dtos;

import br.com.zup.ZupAgenda.mensagem.Mensagem;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastroMensagemDTO {

    @NotBlank(message = "Mensagem não pode ser em branco")
    @Size(max = 250, message = "Tamanho maximo de 250 caracteres")
    private String mensagem;

    public CadastroMensagemDTO() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Mensagem converterDTOParaModel(){
        Mensagem mensagem = new Mensagem();
        mensagem.setMensagem(this.mensagem);

        return mensagem;
    }
}
