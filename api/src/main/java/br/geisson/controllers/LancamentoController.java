package br.geisson.controllers;

import br.geisson.models.Conta;
import br.geisson.models.Lancamento;
import br.geisson.results.LancamentoResult;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@RequestScoped
public class LancamentoController {

    @Inject
    EntityManager em;

    @Inject
    FileController fileController;

    @Transactional
    public Lancamento cadastrar(Lancamento lancamento, Long contaId) {
        Conta conta = em.find(Conta.class, contaId);
        conta.setValor(conta.getValor() + lancamento.getValor());
        lancamento.setConta(conta);
        em.merge(conta);
        em.persist(lancamento);
        em.flush();
        return lancamento;
    }

    public List<LancamentoResult> buscar(Integer ano, Integer mes) {
        String sql = fileController.getSql("lancamento.sql");
        Query q = em.createNativeQuery(sql, LancamentoResult.RESULT_NAME);
        Calendar inicio = Calendar.getInstance();
        inicio.set(ano, mes, 1);
        Calendar fim = Calendar.getInstance();
        fim.set(ano, mes, inicio.getActualMaximum(Calendar.DAY_OF_MONTH));
        q.setParameter("inicio", inicio);
        q.setParameter("fim", fim);
        return q.getResultList();
    }
}
