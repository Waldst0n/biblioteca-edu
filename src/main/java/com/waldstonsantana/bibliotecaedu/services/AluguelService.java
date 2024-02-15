package com.waldstonsantana.bibliotecaedu.services;

import com.waldstonsantana.bibliotecaedu.models.AluguelModel;
import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import com.waldstonsantana.bibliotecaedu.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AluguelService {


    @Autowired
    private AluguelRepository aluguelRepository;

    public List<AluguelModel> findAll() {
        return aluguelRepository.findAll();

    }

    public AluguelModel findById(Long id) {
        AluguelModel aluguel = aluguelRepository.findById(id).get();
        if (aluguel == null){
            throw new RuntimeException("Autor não encontrado");
        } else return aluguel;
    }


}
