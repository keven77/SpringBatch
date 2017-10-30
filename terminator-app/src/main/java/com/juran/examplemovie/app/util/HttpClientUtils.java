package com.juran.examplemovie.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通过httpclient发出请求
 * @author yanqing.guo
 *
 * @date 2016年12月6日
 */
public class HttpClientUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
	
	/**
	 * 发送 get请求
	 */
	public static String getByUrl(String url ) {
		long startTime = System.currentTimeMillis();
		String result="";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget.
			HttpGet httpget = new HttpGet(url);
			logger.info("executing request [ " + httpget.getURI() +" ]");
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				logger.info("--------------------------------------");
				// 打印响应状态
				logger.info(response.getStatusLine().toString());
				if (entity != null) {
					// 打印响应内容长度
					logger.info("Response content length: " +entity.getContentLength()+"("+ entity.getContentLength()/1024.0/1024.0+"MB"+")");
					result=convertStreamToString(entity);
					// 打印响应内容
					//logger.info("Response content: " + result);
				}

				logger.info("------------------------------------");
			} finally {
				response.close();
			}
		} catch (  ParseException | IOException ex) {
			ex.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		String lastJson=result.substring(0,result.lastIndexOf(",\"er\""))+"}";
		long endTime= System.currentTimeMillis();
		long totalTime=endTime-startTime;
		logger.info("执行httpclient耗时:" + totalTime / 1000 + "秒");
		return result;
	}

	public static String convertStreamToString(HttpEntity entity) throws UnsupportedOperationException, IOException {
		InputStream is = entity.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line );//+ "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
