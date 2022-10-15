package com.familiasantanalopes.comerciovirtual.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_carrinho_compra_produto")
public class CarrinhoCompraProduto implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valor;
    private Integer quantidade;
    private String obsevacao;
    private Instant dataCriacao;
    private Instant dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "carrinho_compra_id")
    private CarrinhoCompra carrinhoCompra;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    private Produto produto;

    public CarrinhoCompraProduto(Long id, Double valor, Integer quantidade, String obsevacao,
                                 Instant dataCriacao, Instant dataAtualizacao, CarrinhoCompra carrinhoCompra, Produto produto) {
        this.id = id;
        this.valor = valor;
        this.quantidade = quantidade;
        this.obsevacao = obsevacao;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.carrinhoCompra = carrinhoCompra;
        this.produto = produto;
    }

    public CarrinhoCompraProduto() {

    }

    @Override
    public String toString() {
        return "CarrinhoCompraProdutoController{" +
                "id=" + id +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", obsevacao='" + obsevacao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", carrinhoCompra=" + carrinhoCompra +
                ", produto=" + produto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarrinhoCompraProduto)) return false;
        CarrinhoCompraProduto that = (CarrinhoCompraProduto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getValor(), that.getValor()) && Objects.equals(getQuantidade(), that.getQuantidade()) && Objects.equals(getObsevacao(), that.getObsevacao()) && Objects.equals(getDataCriacao(), that.getDataCriacao()) && Objects.equals(getDataAtualizacao(), that.getDataAtualizacao()) && Objects.equals(getCarrinhoCompra(), that.getCarrinhoCompra()) && Objects.equals(getProduto(), that.getProduto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValor(), getQuantidade(), getObsevacao(), getDataCriacao(), getDataAtualizacao(), getCarrinhoCompra(), getProduto());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getObsevacao() {
        return obsevacao;
    }

    public void setObsevacao(String obsevacao) {
        this.obsevacao = obsevacao;
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

    public CarrinhoCompra getCarrinhoCompra() {
        return carrinhoCompra;
    }

    public void setCarrinhoCompra(CarrinhoCompra carrinhoCompra) {
        this.carrinhoCompra = carrinhoCompra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
