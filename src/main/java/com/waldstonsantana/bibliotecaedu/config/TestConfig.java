package com.waldstonsantana.bibliotecaedu.config;


import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import com.waldstonsantana.bibliotecaedu.models.LocatarioModel;
import com.waldstonsantana.bibliotecaedu.repositories.AutorRepository;
import com.waldstonsantana.bibliotecaedu.repositories.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {




    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LocatarioRepository locatarioRepository;

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        AutorModel joao = new AutorModel(null,"João Gomes", "Masculino", "2000","05415624567");

        autorRepository.save(joao);

        LocatarioModel marcos = new LocatarioModel(null, "Marcos Bispo", "79988234567","Masculino","marcos@gmail.com",LocalDate.parse("12/12/1912",formatter),"05423456789");

        locatarioRepository.save(marcos);

    }
}
