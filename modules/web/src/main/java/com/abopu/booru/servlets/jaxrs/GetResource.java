package com.abopu.booru.servlets.jaxrs;

import com.abopu.booru.db.DAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * @author Sarah Skanes
 * @created April 17, 2016.
 */
@Path("/get")
public class GetResource {
	
	@GET
	@Path("/tags")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<String> getTags() {
		return DAO.getAllTags();
	}
}
