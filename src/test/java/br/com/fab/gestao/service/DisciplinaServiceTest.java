package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Disciplina;
import br.com.fab.gestao.repository.DisciplinaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class DisciplinaServiceTest {

    @Test
    void deveSalvarDisciplina() {
        DisciplinaRepository repo = Mockito.mock(DisciplinaRepository.class);
        DisciplinaService service = new DisciplinaService(repo);

        Disciplina d = new Disciplina();
        d.setNome("Matemática");

        Mockito.when(repo.save(d)).thenReturn(d);

        Disciplina salvo = service.salvar(d);

        assertThat(salvo.getNome()).isEqualTo("Matemática");
    }
}
