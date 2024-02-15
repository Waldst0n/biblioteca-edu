package com.waldstonsantana.bibliotecaedu.resources;

import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import com.waldstonsantana.bibliotecaedu.resources.util.URL;
import com.waldstonsantana.bibliotecaedu.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/autores")
public class AutorResource {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorModel>> findAll() {
        List<AutorModel> list = autorService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AutorModel> findById(@PathVariable Long id) {
        AutorModel obj = autorService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/namesearch", method = RequestMethod.GET)
    public ResponseEntity<Optional<AutorModel>> findByName(@RequestParam(value ="name",defaultValue = "") String name) {

        name = URL.DecodeParam(name);

        Optional<AutorModel> list = autorService.findByName(name);

        return ResponseEntity.ok().body(list);
    }







}
