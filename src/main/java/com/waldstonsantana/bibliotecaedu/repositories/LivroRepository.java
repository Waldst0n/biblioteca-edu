package com.waldstonsantana.bibliotecaedu.repositories;

import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import com.waldstonsantana.bibliotecaedu.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {

}
