package org.oday.Messanger.Resorces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oday.Messanger.Services.MessageAndCommentService;
import org.oday.Messanger.model.Comment;
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResorces {

	private  MessageAndCommentService commentService=MessageAndCommentService.getInestance();
	 
	
	@GET
	public List<Comment> getAllComment(@PathParam("{mid}")long mid){
		return commentService.getAllComments(mid);
		
	}
	@GET
	@Path("/{cid}")
	public Comment getComment(@PathParam("mid")long mid,@PathParam("cid")long cid) {
		return commentService.getComment(mid, cid);
		
		
	}
	@POST
	public Comment addComment(@PathParam("mid")long mid,Comment c) {
		return commentService.addComment(mid, c);
		
	}
	@PUT
	@Path("/{cid}")
	public Comment updateComment(@PathParam("mid")long mid,@PathParam("cid")long cid,Comment c) {
		c.setId(cid);
	return	commentService.updateComment(mid, c);
		
	}
	@DELETE
	@Path("/{cid}")
	public Comment deleteComment(@PathParam("mid")long mid,@PathParam("cid")long cid) {
		return commentService.removeComment(mid, cid);
		
		
	}
	
}
