package com.familiasantanalopes.comerciovirtual.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_permissao_pessoa")
public class PermissaPessoa implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "perisso_id")
    private Perissao perissao;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;
    private Instant dataCreiacao;
    private Instant dataAtualizacao;

    public PermissaPessoa(Long id, Perissao perissao, Pessoa pessoa, Instant dataCreiacao,
                          Instant dataAtualizacao) {
        this.id = id;
        this.perissao = perissao;
        this.pessoa = pessoa;
        this.dataCreiacao = dataCreiacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public PermissaPessoa() {

    }

    @Override
    public String toString() {
        return "PermissaPessoa{" +
                "id=" + id +
                ", perissao=" + perissao +
                ", pessoa=" + pessoa +
                ", dataCreiacao=" + dataCreiacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermissaPessoa)) return false;
        PermissaPessoa that = (PermissaPessoa) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPerissao(), that.getPerissao()) && Objects.equals(getPessoa(), that.getPessoa()) && Objects.equals(getDataCreiacao(), that.getDataCreiacao()) && Objects.equals(getDataAtualizacao(), that.getDataAtualizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPerissao(), getPessoa(), getDataCreiacao(), getDataAtualizacao());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perissao getPerissao() {
        return perissao;
    }

    public void setPerissao(Perissao perissao) {
        this.perissao = perissao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Instant getDataCreiacao() {
        return dataCreiacao;
    }

    public void setDataCreiacao(Instant dataCreiacao) {
        this.dataCreiacao = dataCreiacao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
