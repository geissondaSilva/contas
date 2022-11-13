package br.geisson.conta;

import br.geisson.controllers.ContaController;
import br.geisson.models.Conta;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class ContaCenario {

    @Inject
    ContaController controller;

    public Conta criarNubank() {
        Conta nubank = getNubank();
        controller.cadastrar(nubank);
        return nubank;
    }

    private Conta getNubank() {
        Conta conta = new Conta();
        conta.setNome("Nubank");
        conta.setValor(1000.0);
        return conta;
    }
}
