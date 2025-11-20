
package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Disciplina;
import br.com.fab.gestao.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repo;

    public DisciplinaService(DisciplinaRepository repo) {
        this.repo = repo;
    }

    public List<Disciplina> getAll() {
        return repo.findAll();
    }

    public Disciplina buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        repo.deleteById(id);
    }
}
