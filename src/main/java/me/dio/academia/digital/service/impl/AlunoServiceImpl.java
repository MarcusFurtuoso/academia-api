package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        aluno.setBairro(form.getBairro());

        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(Long id) throws AlunoNotFoundException {
        alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
        
        return alunoRepository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) throws AlunoNotFoundException {
        alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));

        Aluno aluno = alunoRepository.findById(id).get();
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());

        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Long id) throws AlunoNotFoundException {
        alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));

        alunoRepository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacoes(Long id) throws AlunoNotFoundException {
        alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));

        Aluno aluno = alunoRepository.findById(id).get(); 
        
        return aluno.getAvaliacoes();
    }

}
