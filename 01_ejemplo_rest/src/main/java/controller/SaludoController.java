package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/pruebas")
public class SaludoController {
	@GET //el método se ejecutará con peticiones get
	@Path("/saludar")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSaludo() {
		return "Bienvenido a mi servicio REST";
	}
	
	@GET //el método se ejecutará con peticiones get
	@Path("/saludar/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSaludoPersonal(@PathParam("name") String nombre) {
		return "Bienvenido a mi servicio REST sr./a. "+nombre;
	}
	
	@GET //el método se ejecutará con peticiones get
	@Path("/info")
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfo(@QueryParam("name") String nombre,@QueryParam("age") int edad) {
		return "Te llamas "+nombre+" y tienes "+edad+" años";
	}
}
