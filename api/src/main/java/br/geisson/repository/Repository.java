package br.geisson.repository;

import br.geisson.models.EntityId;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Repository<T, I> {

    @Inject
    protected EntityManager em;

    public void salvar(EntityId<I> entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        em.flush();
    }
}
