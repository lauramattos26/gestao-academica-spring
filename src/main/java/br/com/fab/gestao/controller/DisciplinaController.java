package br.com.fab.gestao.controller;

import br.com.fab.gestao.model.Disciplina;
import br.com.fab.gestao.service.DisciplinaService;
import br.com.fab.gestao.repository.DisciplinaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaRepository disciplinaRepository;
    private final DisciplinaService service;

    public DisciplinaController(DisciplinaRepository disciplinaRepository,
            DisciplinaService service) {
        this.disciplinaRepository = disciplinaRepository;
        this.service = service;
    }

    @GetMapping
    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }

    @PostMapping
    public Disciplina criar(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @GetMapping("/{id}")
    public Disciplina buscar(@PathVariable Long id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        disciplinaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Disciplina atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        disciplina.setId(id);
        return disciplinaRepository.save(disciplina);
    }

    // 🔥 AQUI ESTAVA O ERRO — agora funciona
    @GetMapping("/semana")
    public List<Disciplina> disciplinasDaSemana() {
        return service.getAll(); // chama seu serviço corretamente
    }
}
