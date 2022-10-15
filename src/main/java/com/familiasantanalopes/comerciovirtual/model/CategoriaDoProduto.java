package com.familiasantanalopes.comerciovirtual.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_categoria_produto")
public class CategoriaDoProduto implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Instant dataCriacao;
    private Instant dataAtualizacao;

    public CategoriaDoProduto(Long id, String name, Instant dataCriacao, Instant dataAtualizacao) {
        this.id = id;
        this.name = name;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }
    public CategoriaDoProduto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaDoProduto)) return false;
        CategoriaDoProduto that = (CategoriaDoProduto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDataCriacao(), that.getDataCriacao()) && Objects.equals(getDataAtualizacao(), that.getDataAtualizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDataCriacao(), getDataAtualizacao());
    }

    @Override
    public String toString() {
        return "CategoriaDoProduto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
