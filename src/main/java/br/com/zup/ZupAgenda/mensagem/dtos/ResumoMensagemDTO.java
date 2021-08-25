package br.com.zup.ZupAgenda.mensagem.dtos;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class ResumoMensagemDTO {

    private String mensagem;
    private LocalDate dataDeEnvio;
    private boolean visualizado;

    public ResumoMensagemDTO() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getDataDeEnvio() {
        return dataDeEnvio;
    }

    public void setDataDeEnvio(LocalDate dataDeEnvio) {
        this.dataDeEnvio = dataDeEnvio;
    }

    public boolean isVisualizado() {
        return visualizado;
    }

    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }
}
