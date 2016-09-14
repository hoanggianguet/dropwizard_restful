package com.gianghoang.resources;

import com.gianghoang.service.StringService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Rock Lee on 19/08/2016.
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class StringResource {
    StringService stringService = new StringService();
    @GET
    @Path("/ram/{quantity}/{length}")
    public String createRamdomWords(@PathParam("quantity") int quantity, @PathParam("length") int length){
        return stringService.createRamdomWords(quantity,length);
    }
    @GET
    @Path("/disk/5000/1024")
    public String createRandomFile(){
        return stringService.createRamdomFile();
    }
}
