package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Professor;
import br.com.fab.gestao.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository repo;

    public ProfessorService(ProfessorRepository repo) {
        this.repo = repo;
    }

    public Professor salvar(Professor p) {
        return repo.save(p);
    }

    public List<Professor> listar() {
        return repo.findAll();
    }
}
