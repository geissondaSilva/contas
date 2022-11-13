package br.geisson.repository;

import br.geisson.models.Lancamento;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class LancamentoRepository extends Repository<Lancamento, Long> {

}
