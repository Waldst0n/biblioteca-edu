package com.waldstonsantana.bibliotecaedu.services;

import com.waldstonsantana.bibliotecaedu.models.LivroModel;
import com.waldstonsantana.bibliotecaedu.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivroService {


    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll() {
        return livroRepository.findAll();

    }

}
