package com.waldstonsantana.bibliotecaedu.config;


import com.waldstonsantana.bibliotecaedu.models.AluguelModel;
import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import com.waldstonsantana.bibliotecaedu.models.LivroModel;
import com.waldstonsantana.bibliotecaedu.models.LocatarioModel;
import com.waldstonsantana.bibliotecaedu.repositories.AluguelRepository;
import com.waldstonsantana.bibliotecaedu.repositories.AutorRepository;
import com.waldstonsantana.bibliotecaedu.repositories.LivroRepository;
import com.waldstonsantana.bibliotecaedu.repositories.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {




    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LocatarioRepository locatarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AluguelRepository aluguelRepository;


    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        AutorModel joao = new AutorModel(null,"João Gomes", "Masculino", "2000","05415624567");
        AutorModel maria = new AutorModel(null,"Maria Gomes", "Feminino", "1993","12365476898");
        AutorModel augusto = new AutorModel(null, "Augusto Cury", null,"1963","06724357890");


        autorRepository.saveAll(Arrays.asList(joao,maria,augusto));

        LocatarioModel marcos = new LocatarioModel(null, "Marcos Bispo", "79988234567","Masculino","marcos@gmail.com",LocalDate.parse("12/12/1912",formatter),"05423456789");
        LocatarioModel abreu = new LocatarioModel(null, "Abreu Nunes", null,"1591873456","abreu@gmail.com",LocalDate.parse("10/05/1989",formatter),"03876513456");

        locatarioRepository.saveAll(Arrays.asList(marcos,abreu));

        LivroModel domCasmurro = new LivroModel(null,"Dom Casmurro","9788506067420",LocalDate.parse("01/01/1999",formatter));
        LivroModel aGataBorralheira = new LivroModel(null,"A gata borralheira","2546782346578",LocalDate.parse("10/07/1945",formatter));


        livroRepository.saveAll(Arrays.asList(domCasmurro,aGataBorralheira));

        AluguelModel al1 = new AluguelModel(null,LocalDate.parse("22/01/2021",formatter),LocalDate.now());

        al1.getLivros().add(domCasmurro);
        al1.setLocatario(marcos);
        al1.dataDevolucao(al1);

        aluguelRepository.save(al1);

        joao.getLivros().add(domCasmurro);
        maria.getLivros().add(domCasmurro);
        augusto.getLivros().add(aGataBorralheira);
        aGataBorralheira.setAluguelModel(al1);
        domCasmurro.setAluguelModel(al1);




        livroRepository.saveAll(Arrays.asList(domCasmurro,aGataBorralheira));
        autorRepository.saveAll(Arrays.asList(joao,maria,augusto));












    }
}
