package com.familiasantanalopes.comerciovirtual.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_permissao")
public class Perissao implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Instant dataCreiacao;
    private Instant dataAtualizacao;

    public Perissao(Long id, String name, Instant dataCreiacao, Instant dataAtualizacao) {
        this.id = id;
        this.name = name;
        this.dataCreiacao = dataCreiacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Perissao() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Perissao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataCreiacao=" + dataCreiacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Perissao)) return false;
        Perissao perissao = (Perissao) o;
        return Objects.equals(getId(), perissao.getId()) && Objects.equals(getName(), perissao.getName()) && Objects.equals(getDataCreiacao(), perissao.getDataCreiacao()) && Objects.equals(getDataAtualizacao(), perissao.getDataAtualizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDataCreiacao(), getDataAtualizacao());
    }
}
