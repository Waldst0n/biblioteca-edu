package com.waldstonsantana.bibliotecaedu.resources;

import com.waldstonsantana.bibliotecaedu.models.AluguelModel;
import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import com.waldstonsantana.bibliotecaedu.services.AluguelService;
import com.waldstonsantana.bibliotecaedu.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alugueis")
public class AluguelResource {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping
    public ResponseEntity<List<AluguelModel>> findAll() {
        List<AluguelModel> list = aluguelService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AluguelModel> findById(@PathVariable Long id) {
        AluguelModel obj = aluguelService.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
