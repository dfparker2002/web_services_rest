package pl.kwi.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.sun.jersey.api.view.Viewable;

@Path("view")
public class ViewRest {
	
	@GET
	@Path("/{id}")
	@Consumes
	@Produces
	public Viewable displayPage(@PathParam("id")Long id){
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("userId", String.valueOf(id));
		return new Viewable("/jsp/viewJsp.jsp", model);
		
	}
	
	@GET
	@Path("/cancel-button")
	@Consumes
	@Produces
	public void cancelButton(@Context HttpServletResponse response) throws IOException{
		response.sendRedirect("../table");
	}

}
