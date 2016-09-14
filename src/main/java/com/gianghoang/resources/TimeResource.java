package com.gianghoang.resources;

import com.gianghoang.service.TimeService;
import io.dropwizard.hibernate.UnitOfWork;
import org.springframework.web.context.request.async.DeferredResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Rock Lee on 24/08/2016.
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class TimeResource {
    TimeService sleepTimeService = new TimeService();
    @GET
    @Path("/sleep/BIO/{time}")
    @UnitOfWork
    public String timeSleep(@PathParam("time") Long time) throws InterruptedException {
        return sleepTimeService.sleepTime(time);
    }
    @GET
    @Path("/sleep/NIO/{time}")
    public DeferredResult<String> timeSleepAsync(@PathParam("time") Long time) throws InterruptedException {
        return sleepTimeService.timeSleepAsync(time);
    }


}
