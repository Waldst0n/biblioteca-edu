package com.waldstonsantana.bibliotecaedu.resources;

import com.waldstonsantana.bibliotecaedu.models.LivroModel;
import com.waldstonsantana.bibliotecaedu.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll() {
        List<LivroModel> list = livroService.findAll();

        return ResponseEntity.ok().body(list);
    }
}
