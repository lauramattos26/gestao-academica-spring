package br.com.fab.gestao.service;

import br.com.fab.gestao.model.Aviso;
import br.com.fab.gestao.repository.AvisoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class AvisoServiceTest {

    @Test
    void deveSalvarAviso() {
        AvisoRepository repo = Mockito.mock(AvisoRepository.class);
        AvisoService service = new AvisoService(repo);

        Aviso a = new Aviso();
        a.setMensagem("Prova amanhã!");

        Mockito.when(repo.save(a)).thenReturn(a);

        Aviso salvo = service.salvar(a);

        assertThat(salvo.getMensagem()).isEqualTo("Prova amanhã!");
    }
}
