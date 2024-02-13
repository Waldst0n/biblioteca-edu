package com.waldstonsantana.bibliotecaedu.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_autores")
public class AutorModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String sexo;
    private String anoDeNascimento;

    @Id
    @Column(unique = true)
    private String cpf;

    public AutorModel() {

    }

    public AutorModel(String nome, String sexo, String anoDeNascimento, String cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.anoDeNascimento = anoDeNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(String anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorModel that = (AutorModel) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
