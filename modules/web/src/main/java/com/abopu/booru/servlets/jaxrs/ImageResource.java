package com.abopu.booru.servlets.jaxrs;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author Sarah Skanes
 * @created May 16, 2016.
 */
@Path("/uploads")
public class ImageResource {
	
	@PUT
	@Path("/{imageId}")
	public Response getImage(@PathParam("imageId") int id) {
		return null;
	}
}
