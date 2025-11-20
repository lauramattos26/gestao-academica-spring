package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Falta;
import br.com.fab.gestao.repository.FaltaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import br.com.fab.gestao.service.FaltaService;

import static org.assertj.core.api.Assertions.assertThat;

class FaltaServiceTest {

    @Test
    void deveSalvarFalta() {
        FaltaRepository repo = Mockito.mock(FaltaRepository.class);
        FaltaService service = new FaltaService(repo);

        Falta falta = new Falta();
        falta.setJustificativa("Doente");

        Mockito.when(repo.save(falta)).thenReturn(falta);

        Falta salvo = service.salvar(falta);

        assertThat(salvo.getJustificativa()).isEqualTo("Doente");
    }
}
