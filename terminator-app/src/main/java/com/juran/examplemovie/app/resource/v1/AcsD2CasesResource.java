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
import com.juran.examplemovie.app.service.IAcsD2CasesService;
import com.juran.examplemovie.client.bean.domain.D2CaseRetrieveRsp;

import io.swagger.annotations.Api;

@Api(value = "2D方案服务")
@RestLog
@Component
@Path("/v1/acs/2d")
@Produces(MediaType.APPLICATION_JSON)
public class AcsD2CasesResource {
	
	protected final transient Logger infologger = LoggerFactory.getLogger(LoggerName.INFO);

	@Autowired
	private IAcsD2CasesService d2CasesService;
	
	/**
	 * 获取审核中的2D案例
	 * @return
	 */
	@GET
	@Path("/auditWating")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAuditWatingCases(){
		List<D2CaseRetrieveRsp> auditWatingCases = d2CasesService.getAuditWatingCases();
		return Response.status(Status.OK).entity(auditWatingCases).build();
	}
	
	/**
	 * 获取审核成功的2D案例
	 * @return
	 */
	@GET
	@Path("/auditSuccess")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAuditSuccessCases(@QueryParam("limit") int limit,@QueryParam("offset") int offset){
		List<D2CaseRetrieveRsp> auditSuccessCases = d2CasesService.getAuditSuccessCases(limit,offset);
		return Response.status(Status.OK).entity(auditSuccessCases).build();
	}
	
	/**
	 * 获取审核失败的2D案例
	 * @return
	 */
	@GET
	@Path("/auditFail")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAuditFailCases(){
		List<D2CaseRetrieveRsp> auditFailCases = d2CasesService.getAuditFailCases();
		return Response.status(Status.OK).entity(auditFailCases).build();
	}

}
