package br.com.fab.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fab.gestao.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
