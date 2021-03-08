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

import org.oday.Messanger.Services.ProfileService;
import org.oday.Messanger.model.Profile;
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResorces {

	private ProfileService ps=new ProfileService();
	
	@GET
	
	public List<Profile> getAllMessage(){
	return	ps.getAllProfile();
		
		
	}
	
	@POST
	
	public Profile addMessage(Profile m) {
		if(m.getFirstName()==null||m.getLastName()==null||m.getProfileName()==null)
			return null;
		return ps.addProfile(m);
		
	}
	
	
	@GET
	@Path("/{id}")
	
	public Profile getMessage(@PathParam("id")String messageId){
	return	ps.getProfile(messageId);
		
		
	}
	
	
	@PUT
	@Path("/{id}")
	public Profile updateMessage(@PathParam("id")String messageId,Profile m) {
		if(m.getFirstName()==null||m.getLastName()==null||m.getProfileName()==null)
			return null;	
		m.setProfileName(messageId);
		return ps.updateProfile(m);
		
	}
	
	@DELETE
	@Path("/{id}")
	public Profile deleteMessage(@PathParam("id")String messageId) {
		return ps.deleteProfile(messageId);
		
		
	}
}
