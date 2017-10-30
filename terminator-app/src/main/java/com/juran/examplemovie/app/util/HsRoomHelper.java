package com.juran.examplemovie.app.util;


import java.util.ResourceBundle;


public class HsRoomHelper
{
	public static final ResourceBundle BUNDLE;
	static
	{
		BUNDLE = ResourceBundle.getBundle("HsRoomType");
	}

	/**
	 * get SittingRoom<br>
	 * 
	 * @param keyRoom
	 * @return
	 * @return String
	 */
	public static String sittingRoom( final String keyRoom )
	{
		try
		{
			return BUNDLE.getString("SittingRoom-" + keyRoom);
		}
		catch(Exception e)
		{
			// TODO: handle exception
			return null;
		}
	}

	public static String bedRoom( final String keyRoom )
	{
		try
		{
			return BUNDLE.getString("BedRoom-" + keyRoom);
		}
		catch(Exception e)
		{
			// TODO: handle exception
			return null;
		}
	}

	public static String restRoom( final String keyRoom )
	{
		try
		{
			return BUNDLE.getString("RestRoom-" + keyRoom);
		}
		catch(Exception e)
		{
			// TODO: handle exception
			return null;
		}
	}
}
