package com.waldstonsantana.bibliotecaedu.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_autores")
public class AutorModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sexo;
    private String anoDeNascimento;


    @Column(unique = true)
    private String cpf;

    public AutorModel() {

    }

    public AutorModel(Long id, String nome, String sexo, String anoDeNascimento, String cpf) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<LivroModel> getLivros() {
        return livros;
    }

    @ManyToMany
    @JoinTable(name = "autores_livros",
                joinColumns = @JoinColumn(name = "autores_fk"),
                inverseJoinColumns = @JoinColumn(name = "livros_fk"))
    private Set<LivroModel> livros = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorModel that = (AutorModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
