package br.geisson.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categoria")
@SequenceGenerator(name = "categoria_generator", sequenceName = "seq_categoria", allocationSize = 1)
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_generator")
    @Column(name = "categoria_id")
    private Long id;

    private String nome;

    private Boolean ativo;
}
