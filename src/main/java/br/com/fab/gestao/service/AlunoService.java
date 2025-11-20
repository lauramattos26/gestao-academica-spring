package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Aluno;
import br.com.fab.gestao.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    // ✔️ construtor necessário para testes unitários
    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> getAll() {
        return repository.findAll();
    }

    public Aluno getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Aluno create(Aluno aluno) {
        return repository.save(aluno);
    }

    public Aluno update(Long id, Aluno aluno) {
        if (!repository.existsById(id)) {
            return null;
        }

        aluno.setId(id);
        return repository.save(aluno);
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
