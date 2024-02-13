package com.waldstonsantana.bibliotecaedu.config;


import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import com.waldstonsantana.bibliotecaedu.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void run(String... args) throws Exception {

        AutorModel joao = new AutorModel("João Gomes", "Masculino", "2000","05415624567");

        autorRepository.save(joao);
    }
}
