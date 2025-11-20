package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Aluno;
import br.com.fab.gestao.repository.AlunoRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlunoServiceTest {

    @Test
    void deveListarTodosOsAlunos() {
        AlunoRepository repo = mock(AlunoRepository.class);
        AlunoService service = new AlunoService(repo);

        when(repo.findAll()).thenReturn(List.of(new Aluno()));

        var resultado = service.getAll();

        assertEquals(1, resultado.size());
        verify(repo, times(1)).findAll();
    }

    @Test
    void deveBuscarAlunoPorId() {
        AlunoRepository repo = mock(AlunoRepository.class);
        AlunoService service = new AlunoService(repo);

        Aluno aluno = new Aluno();
        aluno.setId(1L);

        when(repo.findById(1L)).thenReturn(Optional.of(aluno));

        var resultado = service.getById(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void deveCriarAluno() {
        AlunoRepository repo = mock(AlunoRepository.class);
        AlunoService service = new AlunoService(repo);

        Aluno aluno = new Aluno();

        when(repo.save(aluno)).thenReturn(aluno);

        var resultado = service.create(aluno);

        assertNotNull(resultado);
        verify(repo, times(1)).save(aluno);
    }

    @Test
    void deveAtualizarAlunoQuandoExiste() {
        AlunoRepository repo = mock(AlunoRepository.class);
        AlunoService service = new AlunoService(repo);

        Aluno aluno = new Aluno();

        when(repo.existsById(1L)).thenReturn(true);
        when(repo.save(any())).thenReturn(aluno);

        var resultado = service.update(1L, aluno);

        assertNotNull(resultado);
        verify(repo, times(1)).save(aluno);
    }

    @Test
    void naoDeveAtualizarAlunoQuandoNaoExiste() {
        AlunoRepository repo = mock(AlunoRepository.class);
        AlunoService service = new AlunoService(repo);

        when(repo.existsById(1L)).thenReturn(false);

        var resultado = service.update(1L, new Aluno());

        assertNull(resultado);
        verify(repo, never()).save(any());
    }

    @Test
    void deveDeletarAlunoQuandoExiste() {
        AlunoRepository repo = mock(AlunoRepository.class);
        AlunoService service = new AlunoService(repo);

        when(repo.existsById(1L)).thenReturn(true);

        boolean resultado = service.delete(1L);

        assertTrue(resultado);
        verify(repo).deleteById(1L);
    }

    @Test
    void naoDeveDeletarAlunoQuandoNaoExiste() {
        AlunoRepository repo = mock(AlunoRepository.class);
        AlunoService service = new AlunoService(repo);

        when(repo.existsById(1L)).thenReturn(false);

        boolean resultado = service.delete(1L);

        assertFalse(resultado);
        verify(repo, never()).deleteById(any());
    }
}
