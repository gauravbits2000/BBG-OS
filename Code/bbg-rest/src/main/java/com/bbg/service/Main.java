package com.bbg.service;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main 
{
	// Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/bbgApp/";

    public static HttpServer startServer() 
    {
    	/*
    	 * ResourceConfig class specifies which package contains annotated Jersey classes to be loaded
    	 * It scans for JAX-RS resources and providers in specified package
    	 */
        final ResourceConfig rc = new ResourceConfig().packages("com.bbg.rest");

        // create and start a new instance of grizzly http server
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
    /**
     *  HTTP server is started and run until the enter key is pressed.
     */
    public static void main(String[] args) throws IOException 
    {
        final HttpServer server = startServer();
        System.out.println(String.format("BBG Jersey app started at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }

}
