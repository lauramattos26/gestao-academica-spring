package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Falta;
import br.com.fab.gestao.repository.FaltaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaltaService {

    private final FaltaRepository repository;

    public FaltaService(FaltaRepository repository) {
        this.repository = repository;
    }

    public List<Falta> getAll() {
        return repository.findAll();
    }

    public Falta getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Falta não encontrada"));
    }

    public Falta salvar(Falta falta) {
        return repository.save(falta);
    }

    public Falta update(Long id, Falta faltaAtualizada) {
        Falta falta = getById(id);

        falta.setAluno(faltaAtualizada.getAluno());
        falta.setDisciplina(faltaAtualizada.getDisciplina());
        falta.setData(faltaAtualizada.getData());
        falta.setJustificativa(faltaAtualizada.getJustificativa());

        return repository.save(falta);
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public Falta justificar(Long id, String justificativa) {
        Falta falta = repository.findById(id).orElse(null);
        if (falta == null) {
            return null;
        }

        falta.setJustificativa(justificativa);
        return repository.save(falta);
    }
}
