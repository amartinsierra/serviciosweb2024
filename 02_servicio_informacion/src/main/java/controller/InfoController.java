package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Ficha;
@Path("/informacion")
public class InfoController {
	@GET
	@Path("/ficha")
	@Produces(MediaType.APPLICATION_JSON)
	public Ficha fichaProducto() {
		return new Ficha("pc",800,"informática");
	}
}
