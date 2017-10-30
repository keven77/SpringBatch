package com.juran.examplemovie.app.resource.v1;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juran.core.log.contants.LoggerName;
import com.juran.core.log.eventlog.aop.RestLog;
import com.juran.examplemovie.app.service.IAcsDemandService;
import com.juran.examplemovie.client.bean.domain.BookingDemand;

import io.swagger.annotations.Api;

@Api(value = "需求项目服务")
@RestLog
@Component
@Path("/v1/acs/demand")
@Produces(MediaType.APPLICATION_JSON)
public class AcsDemandResource {
	
	protected final transient Logger infologger = LoggerFactory.getLogger(LoggerName.INFO);

	@Autowired
	private IAcsDemandService demandService;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDemands(@QueryParam("limit") int limit,@QueryParam("offset") int offset){
		List<BookingDemand> demands = demandService.getDemands(limit, offset);
		return Response.status(Status.OK).entity(demands).build();
	}

}
