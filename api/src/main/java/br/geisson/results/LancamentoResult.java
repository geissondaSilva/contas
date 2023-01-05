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
    private Double valor;
    private String categoria;

    public LancamentoResult() {}

    public LancamentoResult(Long id, Date dataHora, Long contaId, String contaNome, Double valor, String categoria) {
        this.id = id;
        this.dataHora = dataHora;
        this.contaId = contaId;
        this.contaNome = contaNome;
        this.valor = valor;
        this.categoria = categoria;
    }
}
