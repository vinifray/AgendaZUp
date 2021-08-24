package br.com.zup.ZupAgenda.mensagem;

import br.com.zup.ZupAgenda.contato.Contato;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mensagens")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mensagem;
    private LocalDate dataDeEnvio;
    private boolean visualizado;

    @ManyToOne
    @JoinColumn(name = "contato_id", nullable = false)
    private Contato contato;

    public Mensagem() {
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
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
}
