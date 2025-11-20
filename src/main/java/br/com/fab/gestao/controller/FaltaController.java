package br.com.fab.gestao.controller;

import br.com.fab.gestao.model.Falta;
import br.com.fab.gestao.service.FaltaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faltas")
public class FaltaController {

    private final FaltaService service;

    public FaltaController(FaltaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Falta> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Falta getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Falta create(@RequestBody Falta falta) {
        return service.salvar(falta);
    }

    @PutMapping("/{id}")
    public Falta update(@PathVariable Long id, @RequestBody Falta falta) {
        return service.update(id, falta);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PatchMapping("/{id}/justificar")
    public Falta justificar(@PathVariable Long id, @RequestBody String justificativa) {
        return service.justificar(id, justificativa);
    }
}
