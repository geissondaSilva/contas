package br.geisson.controllers;

import java.util.Objects;

import javax.enterprise.context.RequestScoped;

import br.geisson.models.Despesa;
import br.geisson.models.DespesaTipo;

@RequestScoped
public class DespesaController {


    public void validar(Despesa despesa) {
        if (Objects.equals(despesa.getTipo(), DespesaTipo.FIXA)) {
            if (despesa.getDia() == null) {
                // TODO: generate exception "O dia do mes é obrigatório para despesa fixa"
            }
        } else if (Objects.equals(despesa.getTipo(), DespesaTipo.PERIODO)) {
            if (despesa.getInicio() == null || despesa.getFim() == null) {
                // TODO: generate exception "O périodo é obrigatório para despesa em periodo"
            }
        }
    }
    
}
