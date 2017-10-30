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
import com.juran.examplemovie.app.service.IAcsD3CasesService;
import com.juran.examplemovie.client.bean.domain.D3CaseRetrieveRsp;

import io.swagger.annotations.Api;

@Api(value = "3D方案服务")
@RestLog
@Component
@Path("/v1/acs/3d")
@Produces(MediaType.APPLICATION_JSON)
public class AcsD3CasesResource {
	
	protected final transient Logger infologger = LoggerFactory.getLogger(LoggerName.INFO);

	@Autowired
	private IAcsD3CasesService d3CasesService;
	
	@GET
	@Path("/allDesignerCases")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDesigners(@QueryParam("limit") int limit,@QueryParam("offset") int offset){
		List<D3CaseRetrieveRsp> allDesignersCases = d3CasesService.getAllDesignersCases(limit,offset);
		return Response.status(Status.OK).entity(allDesignersCases).build();
	}
	
	@GET
	@Path("/adminCases")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDesignerInfo(@QueryParam("limit") int limit,@QueryParam("offset") int offset){
		List<D3CaseRetrieveRsp> adminCases = d3CasesService.getAdminCases(limit,offset);
		return Response.status(Status.OK).entity(adminCases).build();
	}

}
