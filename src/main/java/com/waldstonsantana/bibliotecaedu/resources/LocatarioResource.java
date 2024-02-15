package com.waldstonsantana.bibliotecaedu.resources;

import com.waldstonsantana.bibliotecaedu.models.LocatarioModel;
import com.waldstonsantana.bibliotecaedu.services.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LocatarioModel> findById(@PathVariable Long id) {
        LocatarioModel obj = locatarioService.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
