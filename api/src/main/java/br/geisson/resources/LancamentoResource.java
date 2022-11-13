package br.geisson.resources;

import br.geisson.controllers.LancamentoController;
import br.geisson.models.Lancamento;
import br.geisson.results.LancamentoResult;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/lancamento")
public class LancamentoResource extends Resource {

    @Inject
    LancamentoController controller;

    @POST
    public Lancamento cadastrar(Lancamento lancamento, @QueryParam("contaId") Long contaId) {
        return controller.cadastrar(lancamento, contaId);
    }

    @GET
    public List<LancamentoResult> get(
            @QueryParam("ano") Integer ano,
            @QueryParam("mes") Integer mes
    ) {
        return controller.buscar(ano, mes);
    }
}
