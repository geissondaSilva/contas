import { LancamentoResult } from "./lancamento-result";

export interface LancamentoDia {
    descricao: string;
    lancamentos: LancamentoResult[];
}