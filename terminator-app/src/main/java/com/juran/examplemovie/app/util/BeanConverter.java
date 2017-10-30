package com.juran.examplemovie.app.util;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;

import com.autodesk.mp.client.models.domainobject.members.result.MembersAsset;
import com.juran.examplemovie.client.bean.domain.BookingDemand;

/**
 * 对象转化类
 * 
 * @author a
 *
 */
public class BeanConverter {
	/**
	 * 获取预约项目
	 * @param membersAsset
	 * @return
	 * @throws ClientProtocolException
	 * @throws UnsupportedOperationException
	 * @throws IOException
     * @throws HttpException
     */
	public static BookingDemand getBookingDemand(MembersAsset membersAsset)
			throws ClientProtocolException, UnsupportedOperationException, IOException, HttpException {
		BookingDemand bookingDemand = new BookingDemand();
		if (membersAsset != null && membersAsset.getExtendedData() != null) {
			bookingDemand = JSONCustomDataUtility.jsonToJavaObject(membersAsset.getExtendedData(), BookingDemand.class);
		}
		return bookingDemand;
	}

}
