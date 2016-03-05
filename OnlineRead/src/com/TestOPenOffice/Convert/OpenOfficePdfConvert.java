package com.TestOPenOffice.Convert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

//转换文档为pdf
public class OpenOfficePdfConvert {
	private static OfficeManager officeManager;// 需要导入一个
	private static String OFFICE_HOME = "D:\\Program Files (x86)\\OpenOffice 4";// 安装OPenOffice的路径
	private static int port[] = { 8100 };

	public void convert2PDF(String inputFile, String outputFile)
			throws IOException {
		/*
		 * 1 进行转换操作 2 start service 3 dealtranlate 3 stop service
		 */
		String fileName1 = inputFile.substring(0, inputFile.lastIndexOf("."));
		if (inputFile.endsWith("txt")) {
			String odtFile = fileName1 + ".odt";
			if (new File(odtFile).exists()) {
				System.out.println("odt文件已存在！");
				inputFile = odtFile;
			} else {
				FileUtils.copyFile(new File(inputFile), new File(odtFile));
				inputFile = odtFile;
			}
		}
		// 开启服务器
		startService();// 进行转换
		System.out.println("进行文档转换转换:" + inputFile + "-->" + outputFile);
		OfficeDocumentConverter converter = new OfficeDocumentConverter(
				officeManager);
		converter.convert(new File(inputFile), new File(outputFile));
		stopService();         // 关闭服务器
		System.out.println();
	}

	// 打开服务器
	public static void startService() {
		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
		try {
			System.out.println("准备启动服务....");
			configuration.setOfficeHome(OFFICE_HOME);// 设置OpenOffice.org安装目录
			configuration.setPortNumbers(port);// 设置转换端口，默认为8100
			configuration.setTaskExecutionTimeout(1000 * 60 * 5L);// 设置任务执行超时为5分钟
			configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);// 设置任务队列超时为24小时
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

	// 进行测试转换是否成功
	/**
	 * 转化效果较好，时间成本低，兼容性高
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String inputFile = "D:\\resource\\三国\\三国演义.doc";
		String outputFile = "D:\\resource\\三国\\三国演义.html";
		OpenOfficePdfConvert opc = new OpenOfficePdfConvert();
		try {
			opc.convert2PDF(inputFile, outputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
