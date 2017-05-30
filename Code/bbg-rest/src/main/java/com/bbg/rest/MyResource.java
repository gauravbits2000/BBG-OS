package com.bbg.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 * Defines the methods for a web service
 */
@Path("myresource")
public class MyResource 
{
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String http://localhost:8080/bbgApp/myresource
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() 
    {
        return "Successfull!";
    }
}
