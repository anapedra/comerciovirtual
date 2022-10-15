package com.familiasantanalopes.comerciovirtual.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_carrinho_compra")
public class CarrinhoCompra implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Instant dataCompra;
    private String observacao;
    private String situacao;
    private Instant dataCriacao;
    private Instant dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;



    public CarrinhoCompra(Long id, Instant dataCompra, String observacao, String situacao, Instant dataCriacao, Instant dataAtualizacao) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.observacao = observacao;
        this.situacao = situacao;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "CarrinhoCompra{" +
                "id=" + id +
                ", dataCompra=" + dataCompra +
                ", observacao='" + observacao + '\'' +
                ", situacao='" + situacao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarrinhoCompra)) return false;
        CarrinhoCompra that = (CarrinhoCompra) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDataCompra(), that.getDataCompra()) && Objects.equals(getObservacao(), that.getObservacao()) && Objects.equals(getSituacao(), that.getSituacao()) && Objects.equals(getDataCriacao(), that.getDataCriacao()) && Objects.equals(getDataAtualizacao(), that.getDataAtualizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataCompra(), getObservacao(), getSituacao(), getDataCriacao(), getDataAtualizacao());
    }

    public CarrinhoCompra() {

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Instant dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
