package com.waldstonsantana.bibliotecaedu.services;

import com.waldstonsantana.bibliotecaedu.models.LocatarioModel;
import com.waldstonsantana.bibliotecaedu.repositories.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocatarioService {


    @Autowired
    private LocatarioRepository locatarioRepository;

    public List<LocatarioModel> findAll() {
        return locatarioRepository.findAll();

    }

    public LocatarioModel findById(Long id) {
        LocatarioModel locatario = locatarioRepository.findById(id).get();
        if (locatario == null){
            throw new RuntimeException("Livro não encontrado");
        } else return locatario;
    }

}
