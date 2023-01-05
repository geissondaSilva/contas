package br.geisson.models;

import br.geisson.results.ContaResult;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "conta")
@Entity
@SqlResultSetMappings({
        @SqlResultSetMapping(name = ContaResult.RESULT_NAME, classes = {
                @ConstructorResult(targetClass = ContaResult.class, columns = {
                        @ColumnResult(name = "conta_id", type = Long.class),
                        @ColumnResult(name = "conta_nome", type = String.class),
                        @ColumnResult(name = "valor", type = Double.class)
                })
        })
})
public class Conta implements EntityId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_generator")
    @Column(name = "conta_id")
    private Long id;

    private String nome;

}
