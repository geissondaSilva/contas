package br.geisson.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaResult {

    public static final String RESULT_NAME = "ContaResult";

    @JsonProperty("id")
    private Long contaId;

    @JsonProperty("nome")
    private String contaNome;

    private Double valor;

    public ContaResult() {}

    public ContaResult(Long contaId, String contaNome, Double valor) {
        this.contaId = contaId;
        this.contaNome = contaNome;
        this.valor = valor;
    }
}
