package br.com.fab.gestao.repository;

import br.com.fab.gestao.model.Falta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaltaRepository extends JpaRepository<Falta, Long> {
}
