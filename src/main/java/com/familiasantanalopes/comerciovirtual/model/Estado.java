package com.familiasantanalopes.comerciovirtual.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_estado")
public class Estado implements Serializable {
    private static final long serialVersionUID=1l;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sigla;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant dataCriação;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant dataAtualizacao;

    public Estado(){

    }

    public Estado(Long id, String nome, String sigla, Instant dataCriação, Instant dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.dataCriação = dataCriação;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Instant getDataCriação() {
        return dataCriação;
    }

    public void setDataCriação(Instant dataCriação) {
        this.dataCriação = dataCriação;
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
        if (!(o instanceof Estado)) return false;
        Estado estado = (Estado) o;
        return Objects.equals(getId(), estado.getId()) && Objects.equals(getNome(), estado.getNome()) && Objects.equals(getSigla(), estado.getSigla()) && Objects.equals(getDataCriação(), estado.getDataCriação()) && Objects.equals(getDataAtualizacao(), estado.getDataAtualizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSigla(), getDataCriação(), getDataAtualizacao());
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", dataCriação=" + dataCriação +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
