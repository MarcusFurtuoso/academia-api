package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.exception.AvaliacaoNotFoundException;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaImpl;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AvaliacaoFisica criar(@RequestBody @Valid AvaliacaoFisicaForm form ) {
        return service.create(form);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacaoFisica atualizar(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm formUpdate) throws AvaliacaoNotFoundException {
        return service.update(id, formUpdate);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacaoFisica get(@PathVariable Long id) throws AvaliacaoNotFoundException {
        return service.get(id);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

}
