package br.geisson.lancamento;

import br.geisson.conta.ContaCenario;
import br.geisson.models.Conta;
import br.geisson.repository.ContaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

public class LancamentoTest {

    @Inject
    ContaCenario contaCenario;

    @Inject
    ContaRepository repository;

    @BeforeEach
    public void beforeEach() {
        contaCenario.criarNubank();
    }

    @Test
    public void test() {
        Conta nubank = repository.buscarPorNome("Nubank");
        assertNotNull(nubank, "Conta nubank não foi encontrada!");
    }

}
