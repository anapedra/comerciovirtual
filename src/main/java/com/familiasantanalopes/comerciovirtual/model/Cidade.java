package com.familiasantanalopes.comerciovirtual.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_cidade")
public class Cidade implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Instant dataCriacao;
    private Instant dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;


    public Cidade(Long id, String name, Instant dataCriacao, Instant dataAtualizacao, Estado estado) {
        this.id = id;
        this.name = name;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.estado = estado;
    }

    public Cidade() {

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(getId(), cidade.getId()) && Objects.equals(getName(),
                cidade.getName()) && Objects.equals(getDataCriacao(), cidade.getDataCriacao()) && Objects.equals(getDataAtualizacao(), cidade.getDataAtualizacao()) && Objects.equals(getEstado(), cidade.getEstado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDataCriacao(), getDataAtualizacao(), getEstado());
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", estado=" + estado +
                '}';
    }
}
