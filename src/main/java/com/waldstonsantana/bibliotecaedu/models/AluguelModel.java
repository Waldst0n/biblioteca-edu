package com.waldstonsantana.bibliotecaedu.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_alugueis")
public class AluguelModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;



    @OneToMany(mappedBy = "aluguelModel")
    private Set<LivroModel> livros = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "locatario_id")
    private LocatarioModel locatario;




    public AluguelModel() {

    }
    public AluguelModel(Long id, LocalDate dataRetirada, LocalDate dataDevolucao) {
        this.id = id;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;


    }

    public Long getId() {
        return id;
    }



    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Set<LivroModel> getLivros() {
        return livros;
    }

    public LocatarioModel getLocatario() {
        return locatario;
    }

    public void setLocatario(LocatarioModel locatario) {
        this.locatario = locatario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AluguelModel that = (AluguelModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public LocalDate dataDevolucao(AluguelModel obj) {
       dataDevolucao = obj.getDataRetirada().plusDays(2);
       return  dataDevolucao;
    }
}
