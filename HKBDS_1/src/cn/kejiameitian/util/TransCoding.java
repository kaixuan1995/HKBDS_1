package cn.kejiameitian.util;

import java.io.UnsupportedEncodingException;

public class TransCoding {
	  
	/**
	 *@Author linhao007
	 *@Decration 数据转码
	 * @param orgin
	 * @return
	 */
	public static String transcoding(String orgin){
		String temp = orgin;
		String notifyName = null;
		byte[] bytes;
		try {
			bytes = temp.getBytes("iso8859-1");
			String notifyTopic=new String(bytes);//则就要先以iso8859-8编码得到字节然后在以utf-8编码 回去�?
		    bytes=notifyTopic.getBytes();
		    bytes=temp.getBytes("iso8859-1");
		    notifyName=new String(bytes,"utf-8");//此乱码的原因�?用request对象得到的参�?是经过utf-8编码再以iso8859-1编码过来的乱�?
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    return notifyName;
	}
	
}
