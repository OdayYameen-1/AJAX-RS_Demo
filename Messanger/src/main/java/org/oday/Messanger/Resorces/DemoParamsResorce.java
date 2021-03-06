package org.oday.Messanger.Resorces;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/DemoParam")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class DemoParamsResorce {
	@GET
	public String getAnotatedParamHere(@MatrixParam("key1")String valueKey1,
								@HeaderParam("headerkey")String valueHeaderKey,
								@CookieParam("cookieKey")String valueCookieKey)
	{
		
		return "Mitrix ==>> "+valueKey1+"\n"+"Header ==>> "+valueHeaderKey+"\n Cookies ==>> "+valueCookieKey;
		
		
	}
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders httpHeaders ) {
		
		String path=uriInfo.getAbsolutePath().toString();
		String Cookies=httpHeaders.getCookies().toString();
		return "path ==> "+path+"\n Cookies ==> "+Cookies;
		
	}
	
}
