package com.familiasantanalopes.comerciovirtual.model;

import jdk.jfr.Timespan;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataValidadeCodigo;
    private String codigoRecuperacaoSenha;
    private String senha;
    private String endereco;
    private Instant dataCriacao;
    private Instant dataAtualozacao;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    @OneToMany(mappedBy = "pessoa",orphanRemoval = true,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<PermissaPessoa> permissaPessoas=new ArrayList<>();
    @OneToMany(mappedBy = "pessoa",orphanRemoval = true,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<CarrinhoCompra> carrinhoCompras=new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getId(), pessoa.getId()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getCpf(), pessoa.getCpf()) && Objects.equals(getEmail(), pessoa.getEmail()) && Objects.equals(getDataValidadeCodigo(), pessoa.getDataValidadeCodigo()) && Objects.equals(getCodigoRecuperacaoSenha(), pessoa.getCodigoRecuperacaoSenha()) && Objects.equals(getSenha(), pessoa.getSenha()) && Objects.equals(getEndereco(), pessoa.getEndereco()) && Objects.equals(getDataCriacao(), pessoa.getDataCriacao()) && Objects.equals(getDataAtualozacao(), pessoa.getDataAtualozacao()) && Objects.equals(getCidade(), pessoa.getCidade()) && Objects.equals(getPermissaPessoas(), pessoa.getPermissaPessoas()) && Objects.equals(getCarrinhoCompras(), pessoa.getCarrinhoCompras());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getEmail(), getDataValidadeCodigo(), getCodigoRecuperacaoSenha(),
                getSenha(), getEndereco(), getDataCriacao(), getDataAtualozacao(), getCidade(), getPermissaPessoas(), getCarrinhoCompras());
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", dataValidadeCodigo=" + dataValidadeCodigo +
                ", codigoRecuperacaoSenha='" + codigoRecuperacaoSenha + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualozacao=" + dataAtualozacao +
                ", cidade=" + cidade +
                ", permissaPessoas=" + permissaPessoas +
                ", carrinhoCompras=" + carrinhoCompras +
                '}';
    }

    public Pessoa(Long id, String nome, String cpf, String email, String codigoRecuperacaoSenha, String senha, String endereco,
                  Instant dataCriacao, Instant dataAtualozacao, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.codigoRecuperacaoSenha= codigoRecuperacaoSenha;
        this.senha = senha;
        this.endereco = endereco;
        this.dataCriacao = dataCriacao;
        this.dataAtualozacao = dataAtualozacao;
        this.cidade = cidade;
    }

    public Pessoa() {

    }

    public List<PermissaPessoa> getPermissaPessoas() {
        return permissaPessoas;
    }

    public void setPermissaPessoas(List<PermissaPessoa> permissaPessoas) {
        for (PermissaPessoa p : permissaPessoas){
            p.setPessoa(this);
        }
        this.permissaPessoas = permissaPessoas;
    }

    public List<CarrinhoCompra> getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public void setCarrinhoCompras(List<CarrinhoCompra> carrinhoCompras) {
        for (CarrinhoCompra cc: carrinhoCompras){
            cc.setPessoa(this);
        }
        this.carrinhoCompras = carrinhoCompras;
    }

    public Date getDataValidadeCodigo() {
        return dataValidadeCodigo;
    }

    public void setDataValidadeCodigo(Date dataValidadeCodigo) {
        this.dataValidadeCodigo = dataValidadeCodigo;
    }

    public String getCodigoRecuperacaoSenha() {
        return codigoRecuperacaoSenha;
    }

    public void setCodigoRecuperacaoSenha(String codigoRecuperacaoSenha) {
        this.codigoRecuperacaoSenha = codigoRecuperacaoSenha;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
