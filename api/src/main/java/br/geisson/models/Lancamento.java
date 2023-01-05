package br.geisson.models;

import br.geisson.results.LancamentoResult;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@SqlResultSetMappings({
        @SqlResultSetMapping(name = LancamentoResult.RESULT_NAME, classes = {
                @ConstructorResult(targetClass = LancamentoResult.class, columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "datahora", type = Date.class),
                        @ColumnResult(name = "contaid", type = Long.class),
                        @ColumnResult(name = "contanome", type = String.class),
                        @ColumnResult(name = "valor", type = Double.class),
                        @ColumnResult(name = "categoria", type = String.class),
                })
        })
})
@Getter
@Setter
@Table(name = "lancamento")
@Entity
public class Lancamento implements EntityId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lancamento_generator")
    @Column(name = "lancamento_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private Double valor;

    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
}
