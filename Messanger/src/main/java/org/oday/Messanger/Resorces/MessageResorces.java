package org.oday.Messanger.Resorces;


import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.oday.Messanger.Exception.DataNotFoundException;
import org.oday.Messanger.Services.MessageAndCommentService;

import org.oday.Messanger.model.Message;





@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResorces {

	private  MessageAndCommentService messageService=MessageAndCommentService.getInestance();
	
	
	@GET
	
	public List<Message> getAllMessage(@QueryParam("year")int year,
									   @QueryParam("start")int start,
									   	@QueryParam("size")int size){
		/*
		 * if(year>0) return messageService.getAllMessageForYear(year); else
		 * if(start>=0&&size>=0) return messageService.getAllMessagePaginated(start,
		 * size);
		 */
	return	messageService.getMessages();
		
		
	}
	
	@POST
	
	public Response addMessage(Message m,@Context UriInfo uriInfo) {
		if(m.getMessage()==null||m.getAuther()==null||m.getCreated()==null)
			return null;
		
		Message newmessage= messageService.addMessage(m);
		String newid=String.valueOf(newmessage.getId());
		URI uri=uriInfo.getAbsolutePathBuilder().path(newid).build();
		return Response.created(uri)
				.entity(newmessage)
				.build();
		
	}
	
	
	@GET
	@Path("/{id}")
	
	public Message getMessage(@PathParam("id")long messageId){
		Message m= messageService.getMessage(messageId);
		if(m==null)
			throw new DataNotFoundException("This id = "+messageId +" nit found ...");
		return m;
	}
	
	
	@PUT
	@Path("/{id}")
	public Message updateMessage(@PathParam("id")Long messageId,Message m) {
		if(m.getMessage()==null||m.getAuther()==null||m.getCreated()==null)
			return null;	
		m.setId(messageId);
		return messageService.updateMessage(m);
		
	}
	
	@DELETE
	@Path("/{id}")
	public Message deleteMessage(@PathParam("id")Long messageId) {
		return messageService.removeMessage(messageId);
		
		
	}
	
	/////////////////////here subresorse
	@Path("/{mid}/comments")
	public CommentsResorces getCommentsResorce() {
		
		return new CommentsResorces();
	}
	
	
	
}
