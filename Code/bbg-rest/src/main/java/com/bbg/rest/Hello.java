package com.bbg.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String plainTextHello(){
		return "Hello ! Jersey Working 1";
	}
	
	
}
