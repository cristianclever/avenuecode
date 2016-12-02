package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/produtos")
public class ServiceResource {

	

	// http://localhost:89/preview/mb/show
	@GET
	@Path("/mb/show")
	@Produces(MediaType.TEXT_HTML)
	/**
	 * O cliente fornece a data na qual
	 * @param gmtDate
	 * @return
	 */
	public String show() {

		// localiza o nome do managedBean
		String resposta = "Teste";
		return resposta;
	}
}
