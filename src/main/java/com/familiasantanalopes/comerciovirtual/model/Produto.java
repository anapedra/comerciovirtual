package com.familiasantanalopes.comerciovirtual.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private Double valorCusto;
    private Double valorVenda;
    private Instant dataCriacao;
    private Instant dataAtualozacao;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaDoProduto categoriaDoProduto;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
    @OneToMany(mappedBy = "produto",orphanRemoval = true,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<CarrinhoCompraProduto> carrinhoCompraProdutos=new ArrayList<>();

    public Produto(Long id, String descricaoCurta, String descricaoDetalhada, Double valorCusto, Double valorVenda,
                   Instant dataCriacao, Instant dataAtualozacao, CategoriaDoProduto categoriaDoProduto, Marca marca) {
        this.id = id;
        this.descricaoCurta = descricaoCurta;
        this.descricaoDetalhada = descricaoDetalhada;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.dataCriacao = dataCriacao;
        this.dataAtualozacao = dataAtualozacao;
        this.categoriaDoProduto = categoriaDoProduto;
        this.marca = marca;
    }

    public Produto() {

    }

    public List<CarrinhoCompraProduto> getCarrinhoCompraProdutos() {
        return carrinhoCompraProdutos;
    }

    public void setCarrinhoCompraProdutos(List<CarrinhoCompraProduto> carrinhoCompraProdutos) {
        for (CarrinhoCompraProduto p : carrinhoCompraProdutos){
            p.setProduto(this);
        }
        this.carrinhoCompraProdutos=carrinhoCompraProdutos;

    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Instant getDataAtualozacao() {
        return dataAtualozacao;
    }

    public void setDataAtualozacao(Instant dataAtualozacao) {
        this.dataAtualozacao = dataAtualozacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoCurta() {
        return descricaoCurta;
    }

    public void setDescricaoCurta(String descricaoCurta) {
        this.descricaoCurta = descricaoCurta;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public CategoriaDoProduto getCategoriaDoProduto() {
        return categoriaDoProduto;
    }

    public void setCategoriaDoProduto(CategoriaDoProduto categoriaDoProduto) {
        this.categoriaDoProduto = categoriaDoProduto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricaoCurta='" + descricaoCurta + '\'' +
                ", descricaoDetalhada='" + descricaoDetalhada + '\'' +
                ", valorCusto=" + valorCusto +
                ", valorVenda=" + valorVenda +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualozacao=" + dataAtualozacao +
                ", categoriaDoProduto=" + categoriaDoProduto +
                ", marca=" + marca +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getId(), produto.getId()) && Objects.equals(getDescricaoCurta(), produto.getDescricaoCurta()) && Objects.equals(getDescricaoDetalhada(), produto.getDescricaoDetalhada()) && Objects.equals(getValorCusto(), produto.getValorCusto()) && Objects.equals(getValorVenda(), produto.getValorVenda()) && Objects.equals(getDataCriacao(), produto.getDataCriacao()) && Objects.equals(getDataAtualozacao(), produto.getDataAtualozacao()) && Objects.equals(getCategoriaDoProduto(), produto.getCategoriaDoProduto()) && Objects.equals(getMarca(), produto.getMarca());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricaoCurta(), getDescricaoDetalhada(), getValorCusto(), getValorVenda(), getDataCriacao(), getDataAtualozacao(), getCategoriaDoProduto(), getMarca());
    }
}

