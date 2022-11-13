package br.geisson.resources;

import br.geisson.controllers.ContaController;
import br.geisson.models.Conta;
import br.geisson.results.ContaResult;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/conta")
public class ContaResource extends Resource {

    @Inject
    ContaController contaController;

    @POST
    public Conta cadastrar(Conta conta) {
        return contaController.cadastrar(conta);
    }

    @GET
    public List<ContaResult> buscarContas() {
        return contaController.buscarContas();
    }
}
