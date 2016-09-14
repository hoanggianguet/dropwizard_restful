package com.gianghoang.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Rock Lee on 19/08/2016.
 */
@Path("/helloworld")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    @Path("/{name}")
    @POST
    public String getName(@PathParam("name") String name) {
        return "Hello " +name;
    }
}
