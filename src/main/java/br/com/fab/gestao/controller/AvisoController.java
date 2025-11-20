package br.com.fab.gestao.controller;

import br.com.fab.gestao.model.Aviso;
import br.com.fab.gestao.service.AvisoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avisos")
public class AvisoController {

    private final AvisoService service;

    public AvisoController(AvisoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aviso> listar() {
        return service.listar();
    }

    @PostMapping
    public Aviso criar(@RequestBody Aviso aviso) {
        return service.salvar(aviso);
    }

    @GetMapping("/{id}")
    public Aviso buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Aviso atualizar(@PathVariable Long id, @RequestBody Aviso aviso) {
        return service.atualizar(id, aviso);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
