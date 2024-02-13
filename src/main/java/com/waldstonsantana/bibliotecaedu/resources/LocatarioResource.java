package com.waldstonsantana.bibliotecaedu.resources;

import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import com.waldstonsantana.bibliotecaedu.models.LocatarioModel;
import com.waldstonsantana.bibliotecaedu.services.AutorService;
import com.waldstonsantana.bibliotecaedu.services.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/locatarios")
public class LocatarioResource {

    @Autowired
    private LocatarioService locatarioService;

    @GetMapping
    public ResponseEntity<List<LocatarioModel>> findAll() {
        List<LocatarioModel> list = locatarioService.findAll();

        return ResponseEntity.ok().body(list);
    }
}
