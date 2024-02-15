package com.waldstonsantana.bibliotecaedu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tb_livros")
public class LivroModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private LocalDate dataDePublicacao;

    @ManyToMany(mappedBy = "livros")
    @Nonnull
    private Set<AutorModel> autores = new HashSet<>();

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "aluguel_id")
    private AluguelModel aluguelModel;

    public LivroModel() {

    }

    public LivroModel(Long id, String name, String isbn, LocalDate dataDePublicacao) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public Set<AutorModel> getAutores() {
        return autores;
    }



    public AluguelModel getAluguelModel() {
        return aluguelModel;
    }

    public void setAluguelModel(AluguelModel aluguelModel) {
        this.aluguelModel = aluguelModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroModel that = (LivroModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
