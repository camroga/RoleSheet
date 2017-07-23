package BuildSoft.rest;

import java.util.HashMap;
import java.lang.reflect.Type;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.multipart.FormDataMultiPart;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BuildSoft.facade.HojaVampiroEdadOscuraFacade;


@Path("hojaVampiroEdadOscura")
public class HojaVampiroEdadOscuraRest {

	@Path("consultarHojaRol")
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	public Response consultarHojaVampiroEdadOscura(@QueryParam("correo") String correo, @QueryParam("nombre")  String nombre) {
		String hojaVampiroEdadOscura = null;
		try {
			hojaVampiroEdadOscura = HojaVampiroEdadOscuraFacade.getInstance().consultarHojaVampiroEdadOscura(correo, nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Response.ok(hojaVampiroEdadOscura, MediaType.APPLICATION_JSON).build();
	}
	
	@Path("consultarHojasRol")
	@POST
//	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces({"application/json"})
//	@Consumes("multipart/form-data")
	public Response consultarHojasVampiro(FormDataMultiPart form) {
		
		Gson objetoJson = new Gson();
		Type type = new TypeToken<HashMap<String, String>>(){}.getType();
		String correo = objetoJson.fromJson(form.getField("correo").getValue(), String.class);
		HashMap<String, String> otrosFiltros = objetoJson.fromJson(form.getField("otrosFiltros").getValue(), type);
		String hojaVampiroEdadOscura = "";
		
		try {
			hojaVampiroEdadOscura = HojaVampiroEdadOscuraFacade.getInstance().consultarHojasVampiro(correo, otrosFiltros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(hojaVampiroEdadOscura, MediaType.APPLICATION_JSON).build();		
	}
	
	@Path("consultarHojasRolInformacionBasica")
	@POST
	public Response consultarHojasVampiroInformacionBasica(FormDataMultiPart form) {
		
		Gson objetoJson = new Gson();
		Type type = new TypeToken<HashMap<String, String>>(){}.getType();
		String correo = objetoJson.fromJson(form.getField("correo").getValue(), String.class);
		HashMap<String, String> otrosFiltros = objetoJson.fromJson(form.getField("otrosFiltros").getValue(), type);
		String hojaVampiroEdadOscura = "";
		
		try {
			hojaVampiroEdadOscura = HojaVampiroEdadOscuraFacade.getInstance().consultarHojasVampiroInformacionBasica(correo, otrosFiltros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(hojaVampiroEdadOscura, MediaType.APPLICATION_JSON).build();		
	}
	
	@Path("guardarHojaRol")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response guardarHojaRolVampiroEdadOscura(String hojaVampiroEdadOscura) {
		
		boolean hojaVampiro = false;
		try {
			hojaVampiro = HojaVampiroEdadOscuraFacade.getInstance().guardarHojaRolVampiroEdadOscura(hojaVampiroEdadOscura);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(hojaVampiro, MediaType.APPLICATION_JSON).build();		
	}
}
