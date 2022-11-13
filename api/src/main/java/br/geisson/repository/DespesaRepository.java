package br.geisson.repository;

import javax.enterprise.context.RequestScoped;

import br.geisson.models.Despesa;

@RequestScoped
public class DespesaRepository extends Repository<Despesa, Long> {
    
}
