package com.bbg.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.bbg.exceptions.DataNotFoundException;
import com.bbg.model.Message;
import com.bbg.service.MessageService;



@Path("/messages")
public class MessageResource {

	private MessageService service = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return service.getMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessages(@PathParam("messageId")long messageId){
		
		if(service.getMessage(messageId) == null){
			throw new DataNotFoundException("Message for Id : "+ messageId +" not found");
		}
		return service.getMessage(messageId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message addMessage(Message message){
		return service.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
		service.updateMessage(message);
		return message;
	}
	
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_XML)
	public void deleteMessage(@PathParam("messageId") long messageId){
		service.removeMessage(messageId);
	}

	
	/**
	 * For Pagination and Queries
	 * 
	 * @return
	 *//*
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size){
		if(year > 0){
			return service.getMessagesForYear(year);
		}
		
		if(start >=0 && size >0){
			return service.getMessagesForPagination(start, size);
		}
		
		return service.getMessages();
	}
	
	
	*//**
	 * using context annotation
	 * @return
	 *//*
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getMessages(@Context UriInfo uriInfo, @Context HttpHeaders headerInfo){
		System.out.println("Path : " + uriInfo.getAbsolutePath());
		System.out.println("HeaderInfo : " + headerInfo.getCookies().toString());
		List<Message> messages = service.getMessages();
		return  Response.status(Status.FOUND).entity(messages.get(0)).build();
		
	}*/
}
