package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Professor;
import br.com.fab.gestao.repository.ProfessorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class ProfessorServiceTest {

    @Test
    void deveSalvarProfessor() {
        ProfessorRepository repo = Mockito.mock(ProfessorRepository.class);
        ProfessorService service = new ProfessorService(repo);

        Professor p = new Professor();
        p.setNome("Carlos");

        Mockito.when(repo.save(p)).thenReturn(p);

        Professor salvo = service.salvar(p);

        assertThat(salvo.getNome()).isEqualTo("Carlos");
    }
}

