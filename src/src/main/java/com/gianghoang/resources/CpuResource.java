package com.gianghoang.resources;

import com.gianghoang.service.ServiceCpu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Rock Lee on 19/08/2016.
 */
@Path("/cpu")
@Produces(MediaType.APPLICATION_JSON)
public class CpuResource {

    @GET
    public String testCpu(){
        ServiceCpu cpuService = new ServiceCpu();
        cpuService.testHighCpu();
        return "ok";
    }
}
