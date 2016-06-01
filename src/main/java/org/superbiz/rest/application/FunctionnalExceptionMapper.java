package org.superbiz.rest.application;

import javax.ejb.EJBException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by eric on 20/05/16.
 */
@Provider
public class FunctionnalExceptionMapper implements ExceptionMapper<FunctionnalException>
{

    public Response toResponse(FunctionnalException exception) {
        System.out.println("filter d'exception");
        return Response.status(500).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").build();
    }

}