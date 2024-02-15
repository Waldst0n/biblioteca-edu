package com.waldstonsantana.bibliotecaedu.repositories;

import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {

        Optional<AutorModel> findByNomeContainingIgnoreCase(String name);
}
