package com.familiasantanalopes.comerciovirtual.dtos;


import com.familiasantanalopes.comerciovirtual.model.Cidade;

import java.util.Objects;

public class PessoaCliesteRequesteDTO {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String endereco;
    private Cidade Cidade;

    public PessoaCliesteRequesteDTO(String nome, String cpf, String email, String senha,
                                    String endereco, com.familiasantanalopes.comerciovirtual.model.Cidade cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        Cidade = cidade;
    }
    public PessoaCliesteRequesteDTO(){
    }

    @Override
    public String toString() {
        return "PessoaCliesteRequesteDTO{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco='" + endereco + '\'' +
                ", Cidade=" + Cidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaCliesteRequesteDTO)) return false;
        PessoaCliesteRequesteDTO that = (PessoaCliesteRequesteDTO) o;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getCpf(), that.getCpf()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getSenha(), that.getSenha()) && Objects.equals(getEndereco(), that.getEndereco()) && Objects.equals(getCidade(), that.getCidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCpf(), getEmail(), getSenha(), getEndereco(), getCidade());
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

    public com.familiasantanalopes.comerciovirtual.model.Cidade getCidade() {
        return Cidade;
    }

    public void setCidade(com.familiasantanalopes.comerciovirtual.model.Cidade cidade) {
        Cidade = cidade;
    }
}
