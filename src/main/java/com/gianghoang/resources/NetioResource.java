package com.gianghoang.resources;

import com.gianghoang.service.NetioService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Rock Lee on 19/08/2016.
 */
@Path("/netio")
@Produces(MediaType.APPLICATION_JSON)
public class NetioResource {
    NetioService netioService = new NetioService();
    @GET()
    @Path("/{length}")
    public String getString(@PathParam("length") int length){

        return netioService.getString(length);
    }
}
