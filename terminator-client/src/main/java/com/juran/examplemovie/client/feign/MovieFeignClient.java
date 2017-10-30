package com.juran.examplemovie.client.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.juran.examplemovie.client.bean.request.MovieInsertReqBean;
import com.juran.examplemovie.client.bean.request.MovieUpdateReqBean;
import com.juran.examplemovie.client.bean.response.MovieAndUserGetRespBean;
import com.juran.examplemovie.client.bean.response.MovieGetPageRespBean;
import com.juran.examplemovie.client.bean.response.MovieGetRespBean;

@FeignClient(name="examplemovie-app",fallbackFactory=MovieFeignClientFallbackFactory.class,url="${examplemovie-app.feign.url:}")
public interface MovieFeignClient {
	@RequestMapping(path="/api/v1/movies/{movieId}",method=RequestMethod.GET)
	public MovieAndUserGetRespBean getMovie(@PathVariable("movieId") Long movieId);
	
	@RequestMapping(path="/api/v1/movies",method=RequestMethod.GET)
	public List<MovieGetRespBean> listMovies(
			@RequestParam("id") String id , 
			@RequestParam("name") String name ,
			@RequestParam("sex") String sex);
	
	@RequestMapping(path="/api/v1/movies/page",method=RequestMethod.GET)
	public MovieGetPageRespBean pageMovies(
			@RequestParam("id") String id , 
			@RequestParam("name") String name ,
			@RequestParam("sex") String sex,
			@RequestParam("offset") Integer offset,
			@RequestParam("limit") Integer limit);
	
	@RequestMapping(path="/api/v1/movies",method=RequestMethod.PUT)
	public String updateMovie(@RequestBody MovieUpdateReqBean movieUpdateReqBean);
	
	@RequestMapping(path="/api/v1/movies",method=RequestMethod.POST)
	public String insertMovie(@RequestBody MovieInsertReqBean movieInsertReqBean);
}
