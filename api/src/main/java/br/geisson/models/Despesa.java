package br.geisson.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Despesa
 */
@Getter
@Setter
@Entity
@Table(name = "despesa")
public class Despesa {

    @Id
    private Long id;

    private String descricao;

    private DespesaTipo tipo;

    private Integer dia;

    private TipoValor smallint;

    private Float valor;

    private Integer parcela;

    private Date data;

    private Date inicio;

    private Date fim;

}