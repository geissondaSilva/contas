package br.geisson.results;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LancamentoResult {

    public static final String RESULT_NAME = "LancamentoResult";

    private Long id;
    private Date dataHora;
    private Long contaId;
    private String contaNome;

    public LancamentoResult() {}

    public LancamentoResult(Long id, Date dataHora, Long contaId, String contaNome) {
        this.id = id;
        this.dataHora = dataHora;
        this.contaId = contaId;
        this.contaNome = contaNome;
    }
}
