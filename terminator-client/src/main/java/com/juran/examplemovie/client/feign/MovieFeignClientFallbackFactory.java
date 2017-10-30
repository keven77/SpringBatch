package com.juran.examplemovie.client.feign;

import java.util.List;

import org.springframework.stereotype.Component;

import com.juran.examplemovie.client.bean.request.MovieInsertReqBean;
import com.juran.examplemovie.client.bean.request.MovieUpdateReqBean;
import com.juran.examplemovie.client.bean.response.MovieAndUserGetRespBean;
import com.juran.examplemovie.client.bean.response.MovieGetPageRespBean;
import com.juran.examplemovie.client.bean.response.MovieGetRespBean;

import feign.hystrix.FallbackFactory;

@Component
public class MovieFeignClientFallbackFactory implements FallbackFactory<MovieFeignClient> {

	@Override
	public MovieFeignClient create(Throwable cause) {
		MovieFeignClient movieFeignClient=new MovieFeignClient() {
			
			@Override
			public String updateMovie(MovieUpdateReqBean movieUpdateReqBean) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MovieGetPageRespBean pageMovies(String id, String name, String sex, Integer offset, Integer limit) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<MovieGetRespBean> listMovies(String id, String name, String sex) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String insertMovie(MovieInsertReqBean movieInsertReqBean) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MovieAndUserGetRespBean getMovie(Long movieId) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return movieFeignClient;
	}

}
