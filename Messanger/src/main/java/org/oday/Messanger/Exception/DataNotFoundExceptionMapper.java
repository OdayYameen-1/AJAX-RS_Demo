package org.oday.Messanger.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.oday.Messanger.model.ExciptionError;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ExciptionError exciptionError=new ExciptionError(exception.getMessage(), 404);
		return Response.status(Status.NOT_FOUND)
				.entity(exciptionError)
				.build();
	}

}
