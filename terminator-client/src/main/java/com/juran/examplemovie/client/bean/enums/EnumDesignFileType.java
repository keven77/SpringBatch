package com.juran.examplemovie.client.bean.enums;


/**
 * 3D DesignFile 类型
 * 
 * @author Jonathan
 * @version 2016年5月28日 2016年5月28日 下午7:48:42 Jonathan 创建
 */
public enum EnumDesignFileType
{

	/**
	 * @Fields BOM BOM
	 */
	BOM("2"),

	/**
	 * @Fields CAD TODO CAD
	 */
	CAD("3"),

	/**
	 * @Fields DECORATIONCASE DecorationCase
	 */
	DECORATIONCASE("5"),

	/**
	 * @Fields OTHERS Others
	 */
	OTHERS("7"),

	/**
	 * @Fields PANORAMA 全景渲染图
	 */
	PANORAMA("4"),

	/**
	 * @Fields PLANVIEW3D 平面图
	 */
	PLANVIEW3D("8"),

	/**
	 * @Fields RENDER 普通渲染图
	 */
	RENDER("0"),

	/**
	 * @Fields SNAPSHOT 截图
	 */
	SNAPSHOT("6"),

	/**
	 * @Fields THREEDIMENSIONAL ThreeDimensional
	 */
	THREEDIMENSIONAL("1"),

	/**
	 * @Fields UNITMAP2D 2d户型图
	 */
	UNITMAP2D("9"),

	/**
	 * @Fields UNITMAP3D 3d户型图
	 */
	UNITMAP3D("10"),
	/**
	 * @Fields PANO 全屋漫游图
	 */
	PANO("11"),

	/**
	 * @Fields NULL 封面（为封面赋值，不显示在任何列表中）
	 */
	NULL("-1");

	public static EnumDesignFileType getEnum( final String val )
	{
		for( EnumDesignFileType type : EnumDesignFileType.values() )
		{
			if(type.getValue().equals(val))
			{
				return type;
			}
		}
		return null;
	}

	public static String getValue( final EnumDesignFileType val )
	{
		return val.getValue();
	}

	private final String value;

	EnumDesignFileType( String value )
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}
