package br.com.zup.ZupAgenda.mensagem.dtos;

import br.com.zup.ZupAgenda.contato.dtos.ContatoDTO;
import br.com.zup.ZupAgenda.mensagem.Mensagem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

public class MensagemDTO {
    private Integer id;
    private String mensagem;
    private LocalDate dataDeEnvio;
    private boolean visualizado;

    private ContatoDTO contatoDTO;

    public MensagemDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ContatoDTO getContatoDTO() {
        return contatoDTO;
    }

    public void setContatoDTO(ContatoDTO contatoDTO) {
        this.contatoDTO = contatoDTO;
    }

    public static MensagemDTO converterModelParaDTO(Mensagem mensagem){
        MensagemDTO mensagemDTO = new MensagemDTO();
        ContatoDTO contatoDTO = ContatoDTO.converterModelParaDTO(mensagem.getContato());

        mensagemDTO.setContatoDTO(contatoDTO);
        mensagemDTO.setMensagem(mensagem.getMensagem());
        mensagemDTO.setVisualizado(mensagem.isVisualizado());
        mensagemDTO.setDataDeEnvio(mensagem.getDataDeEnvio());
        mensagemDTO.setId(mensagem.getId());

        return mensagemDTO;
    }
}
