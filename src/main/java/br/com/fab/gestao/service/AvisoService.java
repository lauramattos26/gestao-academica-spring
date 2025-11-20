package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Aviso;
import br.com.fab.gestao.repository.AvisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisoService {

    private final AvisoRepository repo;

    public AvisoService(AvisoRepository repo) {
        this.repo = repo;
    }

    public Aviso salvar(Aviso aviso) {
        return repo.save(aviso);
    }

    public List<Aviso> listar() {
        return repo.findAll();
    }

    public Aviso buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Aviso atualizar(Long id, Aviso aviso) {
        if (!repo.existsById(id)) {
            return null;
        }

        aviso.setId(id);
        return repo.save(aviso);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
