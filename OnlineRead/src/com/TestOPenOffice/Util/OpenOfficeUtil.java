package com.TestOPenOffice.Util;

import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

public class OpenOfficeUtil {
	private static OfficeManager officeManager = null;
	public static void startService() {
		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
		try {
			System.out.println("准备启动服务....");
			configuration.setOfficeHome("D:\\Program Files (x86)\\OpenOffice 4");// 设置OpenOffice.org安装目录6configuration.setPortNumbers(port);//设置转换端口，默认为8100
			configuration.setTaskExecutionTimeout(1000 * 60 * 5L);// 设置任务执行超时为5分钟8configuration.setTaskQueueTimeout(1000*60*60*24L);//设置任务队列超时为24小时
			officeManager = configuration.buildOfficeManager();
			officeManager.start();// 启动服务
			System.out.println("office转换服务启动成功!");

		} catch (Exception ce) {

			System.out.println("office转换服务启动失败!详细信息:" + ce);
		}
	}

	// 关闭服务器
	public static void stopService() {
		System.out.println("关闭office转换服务....");
		if (officeManager != null) {
			officeManager.stop();
		}
		System.out.println("关闭office转换成功!");
	}
}
