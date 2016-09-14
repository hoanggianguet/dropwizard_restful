package com.gianghoang.resources;

import com.gianghoang.service.RSAService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.GeneralSecurityException;

/**
 * Created by Rock Lee on 19/08/2016.
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class RsaResource {
    RSAService rsaService = new RSAService();

    @GET
    @Path("/rsa/5000/1024")
    public String RSA1024() throws GeneralSecurityException {
        boolean keyexist = true;
        for (int i = 0; i < 5000; i++) {
            rsaService.RSAcrypto(1024, keyexist);
            keyexist = false;
        }
        if (keyexist == false){
            return "True";
        }else {
            return "False";
        }
    }


    @GET
    @Path("/rsa/5000/512")
    public void RSA512() throws GeneralSecurityException {
        boolean keyexist = true;
        for (int i = 0; i < 5000; i++) {
            rsaService.RSAcrypto(512, keyexist);
            keyexist = false;
        }
    }


    @GET
    @Path("/rsa/5000/2048")
    public void RSA2048() throws GeneralSecurityException {
        boolean keyexist = true;
        for (int i = 0; i < 5000; i++) {
            rsaService.RSAcrypto(2048, keyexist);
            keyexist = false;
        }

    }

}
