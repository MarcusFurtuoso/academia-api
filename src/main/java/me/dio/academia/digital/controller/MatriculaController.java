package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.exception.MatriculaNotFoundException;
import me.dio.academia.digital.service.impl.MatriculaImpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Matricula criar(@RequestBody @Valid MatriculaForm form) throws Exception {
        return service.create(form);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Matricula get(@PathVariable Long id) throws MatriculaNotFoundException {
        return service.get(id);   
    }

    @GetMapping
    public List<Matricula> getAll() {
        return service.getAll();
    }


}
