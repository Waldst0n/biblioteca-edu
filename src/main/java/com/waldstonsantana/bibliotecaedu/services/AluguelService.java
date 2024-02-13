package com.waldstonsantana.bibliotecaedu.services;

import com.waldstonsantana.bibliotecaedu.models.AluguelModel;
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

}
