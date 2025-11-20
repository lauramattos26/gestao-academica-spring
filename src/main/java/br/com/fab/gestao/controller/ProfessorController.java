package br.com.fab.gestao.controller;

import br.com.fab.gestao.model.Professor;
import br.com.fab.gestao.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    @PostMapping
    public Professor criar(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @GetMapping("/{id}")
    public Professor buscar(@PathVariable Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable Long id, @RequestBody Professor professor) {
        professor.setId(id);
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }
}
