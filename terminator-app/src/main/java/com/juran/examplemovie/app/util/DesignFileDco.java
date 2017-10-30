package com.juran.examplemovie.app.util;


import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.juran.examplemovie.client.bean.domain.DesignFile;
import com.juran.examplemovie.client.bean.enums.EnumDesignFileType;


/**
 * 3D文件操作
 * 
 * @author songsen.zhang
 * @version 2016年6月15日 2016年6月15日 下午7:15:18 songsen.zhang 创建
 */
public class DesignFileDco
{
	static class FileRsp
	{

		/**
		 * @Fields files files
		 */
		private List<DesignFile>	files;

		/**
		 * @Fields ids delete ids
		 */
		private List<String>		ids;

		public FileRsp()
		{
			super();
		}
		public FileRsp( List<String> ids, List<DesignFile> files )
		{
			super();
			this.ids = ids;
			this.files = files;
		}
		public List<DesignFile> getFiles()
		{
			return files;
		}
		public List<String> getIds()
		{
			return ids;
		}
		public void setFiles( List<DesignFile> files )
		{
			this.files = files;
		}
		public void setIds( List<String> ids )
		{
			this.ids = ids;
		}
	}

	/**
	 * 添加文件<br>
	 * 
	 * @param designFiles
	 *            文件集合
	 * @param DesignFileReq
	 *            文件
	 */
	public static void add( List<DesignFile> designFiles, final DesignFile designFile )
	{
		designFiles.add(designFile);
	}

	/**
	 * 新增文件到String类型JSON字符串中<br>
	 * 
	 * @param designFilesJson
	 *            文件集合
	 * @param DesignFileReq
	 *            文件
	 * @return 文件集合
	 * @return List<DesignFile>
	 */
	public static List<DesignFile> add( final String designFilesJson, final DesignFile designFile )
	{
		List<DesignFile> designFiles = convertJsonToArray(designFilesJson);

		add(designFiles, designFile);

		return designFiles;
	}

	/**
	 * 将文件集合转变为String类型JSON字符串<br>
	 * 
	 * @param designFiles
	 *            文件集合
	 * @return String类型JSON字符串
	 */
	public static String convertArrayToJson( final List<DesignFile> designFiles )
	{
		final String designFilesJson = JSON.toJSONString(designFiles).replace("\"", "'").replaceAll("&", "&");

		return designFilesJson;
	}

	/**
	 * 将String类型JSON字符串转变为文件集合<br>
	 * 
	 * @param designFilesJson
	 *            String类型JSON字符串
	 * @return 文件集合
	 * @return List<DesignFile>
	 */
	public static List<DesignFile> convertJsonToArray( final String designFilesJson )
	{
		List<DesignFile> list;
		try
		{
			list = (ArrayList<DesignFile>) JSON.parseArray(StringUtils.isEmpty(designFilesJson) ? "[]" : designFilesJson, DesignFile.class);
		}
		catch(Exception e)
		{
			list = new ArrayList<DesignFile>();
		}
		return list;
	}

	/**
	 * 删除文件<br>
	 * 
	 * @param designFiles
	 *            文件集合
	 * @return 删除文件ID列表
	 * @return List<String>
	 */
	public static FileRsp delete( List<DesignFile> designFiles )
	{
		if(designFiles == null)
		{
			return null;
		}
		List<String> result = new ArrayList<String>();
		List<DesignFile> files = new ArrayList<DesignFile>();
		for( int i = 0; i < designFiles.size(); i++ )
		{
			DesignFile designFile = designFiles.get(i);
			EnumDesignFileType designFileType = EnumDesignFileType.getEnum(designFile.getType());
			if(EnumDesignFileType.UNITMAP2D.equals(designFileType) || EnumDesignFileType.UNITMAP3D.equals(designFileType) || EnumDesignFileType.PLANVIEW3D.equals(designFileType))
			{
				result.add(designFile.getId());
				designFiles.remove(i);
				i--;
				continue;
			}
			files.add(designFile);
		}
		return new FileRsp(result, files);
	}

	/**
	 * 修改文件<br>
	 * 
	 * @param designFiles
	 *            文件集合
	 * @param DesignFileReq
	 *            修改文件信息
	 */
	public static void update( List<DesignFile> designFiles, final DesignFile designFile )
	{
		delete(designFiles);
		add(designFiles, designFile);
	}

	/**
	 * @Fields designFiles 文件集合
	 */
	private List<DesignFile> designFiles;

	/**
	 * <p>
	 * method name DesignFileDco.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 */
	public DesignFileDco()
	{
		super();
	}

	/**
	 * <p>
	 * method name DesignFileDco.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param designFiles
	 */
	public DesignFileDco( List<DesignFile> designFiles )
	{
		super();
		this.designFiles = designFiles;
	}

	/**
	 * <p>
	 * method name DesignFileDco.java
	 * </p>
	 * <p>
	 * Description本类的构造函数
	 * </p>
	 * 
	 * @param designFilesJson
	 */
	public DesignFileDco( final String designFilesJson )
	{
		super();
		this.designFiles = convertJsonToArray(designFilesJson);
	}

	/**
	 * 添加文件<br>
	 * 
	 * @param designFile
	 *            文件
	 */
	public void add( final DesignFile designFile )
	{
		designFiles.add(designFile);
	}

	/**
	 * 添加文件集合到指定集合<br>
	 * 
	 * @param designFiles
	 *            需要添加的文件集合
	 */
	public void add( final List<DesignFile> designFiles )
	{
		for( DesignFile designFile : designFiles )
		{
			Boolean add = true;
			for( DesignFile file : this.designFiles )
			{
				if(!StringUtils.isEmpty(file.getSourceId()))
				{
					if(file.getSourceId().equals(designFile.getSourceId()))
					{
						add = false;
						break;
					}
				}
			}
			if(add)
			{
				this.designFiles.add(designFile);
			}
		}
	}

	/**
	 * 将文件集合转变为String类型JSON字符串<br>
	 * 
	 * @return String类型JSON字符串
	 */
	public String convertArrayToJson()
	{
		return convertArrayToJson(designFiles);
	}

	/**
	 * 将String类型JSON字符串转变为文件集合<br>
	 * 
	 * @param designFilesJson
	 *            String类型JSON字符串
	 */
	public void convertJsonToPriArray( final String designFilesJson )
	{
		designFiles = convertJsonToArray(designFilesJson);
	}

	/**
	 * 删除文件<br>
	 * 
	 * @param DesignFileReq
	 *            删除的文件
	 * @return 删除文件ID列表
	 * @return List<String>
	 */
	public List<String> delete()
	{
		FileRsp rsp = delete(designFiles);
		designFiles = rsp.getFiles();
		return rsp.getIds();
	}

	/**
	 * 获取文件集合<br>
	 * 
	 * @return 文件集合
	 * @return List<DesignFile>
	 */
	public List<DesignFile> getDesignFiles()
	{
		return designFiles;
	}

	/**
	 * 赋值 文件集合<br>
	 * 
	 * @param designFiles
	 *            文件集合
	 */
	public void setDesignFiles( List<DesignFile> designFiles )
	{
		this.designFiles = designFiles;
	}

	/**
	 * 修改文件<br>
	 * 
	 * @param DesignFileReq
	 *            修改文件信息
	 */
	public void update( final DesignFile designFile )
	{
		update(designFiles, designFile);
	}
}
