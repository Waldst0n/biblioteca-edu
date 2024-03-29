package com.waldstonsantana.bibliotecaedu.services;

import com.waldstonsantana.bibliotecaedu.models.AutorModel;
import com.waldstonsantana.bibliotecaedu.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AutorService {


    @Autowired
    private AutorRepository autorRepository;

    public List<AutorModel> findAll() {
        return autorRepository.findAll();

    }

    public  AutorModel findById(Long id) {
        AutorModel autor = autorRepository.findById(id).get();
        if (autor == null){
            throw new RuntimeException("Autor não encontrado");
        } else return autor;
    }


    public Optional<AutorModel> findByName(String name) {
        return  autorRepository.findByNomeContainingIgnoreCase(name);
    }

    public AutorModel insert(AutorModel obj) {
        return autorRepository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        autorRepository.deleteById(id);
    }

    public AutorModel update(Long id, AutorModel obj) {
       AutorModel newObj = autorRepository.getReferenceById(id);
       updateData(newObj,obj);
       return autorRepository.save(newObj);
    }

    private void updateData(AutorModel newObj, AutorModel obj) {
        newObj.setNome(obj.getNome());
        newObj.setSexo(obj.getSexo());
        newObj.setCpf(obj.getCpf());
        newObj.setAnoDeNascimento(obj.getAnoDeNascimento());

    }

}
