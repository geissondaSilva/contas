package br.geisson.repository;

import br.geisson.models.Conta;
import br.geisson.results.ContaResult;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequestScoped
public class ContaRepository extends Repository<Conta, Long> {

    @Inject
    EntityManager em;

    public List<ContaResult> buscarContas() {
        Query q = em.createNativeQuery("select\n" +
                "\tconta.conta_id,\n" +
                "\tconta.nome conta_nome,\n" +
                "\tsum(lancamento.valor) valor\n" +
                "from lancamento lancamento\n" +
                "join conta conta on conta.conta_id = lancamento.conta_id\n" +
                "group by conta.conta_id, conta_nome;", ContaResult.RESULT_NAME);
        return q.getResultList();
    }

    public Conta buscarPorNome(String nome) {
        Query q = em.createQuery("select c from Conta c where c.nome = :nome");
        q.setParameter("nome", nome);
        return (Conta) q.getSingleResult();
    }
}
