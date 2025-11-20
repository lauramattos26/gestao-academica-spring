package br.com.fab.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fab.gestao.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
