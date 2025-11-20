package br.com.fab.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fab.gestao.model.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {
}
