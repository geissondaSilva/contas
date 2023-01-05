package br.geisson.controllers;

import br.geisson.models.Conta;
import br.geisson.models.Lancamento;
import br.geisson.repository.ContaRepository;
import br.geisson.repository.LancamentoRepository;
import br.geisson.results.ContaResult;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class ContaController {

    @Inject
    ContaRepository repository;

    @Inject
    LancamentoRepository lancamentoRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Conta cadastrar(Conta conta) {
        repository.salvar(conta);
        return conta;
    }

    public List<ContaResult> buscarContas() {
        return repository.buscarContas();
    }

}
