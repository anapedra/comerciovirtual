package com.familiasantanalopes.comerciovirtual.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_marca")
public class Marca implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Instant dataCreicao;
    private Instant dataAtualizacao;

    public Marca(Long id, String name, Instant dataCreicao, Instant dataAtualizacao) {
        this.id = id;
        this.name = name;
        this.dataCreicao = dataCreicao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Marca() {

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

    public Instant getDataCreicao() {
        return dataCreicao;
    }

    public void setDataCreicao(Instant dataCreicao) {
        this.dataCreicao = dataCreicao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Marca)) return false;
        Marca marca = (Marca) o;
        return Objects.equals(getId(), marca.getId()) && Objects.equals(getName(), marca.getName()) && Objects.equals(getDataCreicao(), marca.getDataCreicao()) && Objects.equals(getDataAtualizacao(), marca.getDataAtualizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDataCreicao(), getDataAtualizacao());
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataCreicao=" + dataCreicao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
