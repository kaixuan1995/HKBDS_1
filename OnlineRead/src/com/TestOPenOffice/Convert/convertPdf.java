package com.TestOPenOffice.Convert;

import java.io.File;
import java.io.IOException;

//转换成swf 格式的
public class convertPdf {

	/**
	 * @param args
	 */
	private static String PDF2SWF_PATH = "D:\\Program Files (x86)\\SWFTools\\pdf2swf.exe";// swftools
																							// 工具的安装路径

	public void convertPDF(String inputFile, String outputFile) {
		File pdfFile = new File(inputFile);
		File swfFile = new File(outputFile);
		if (!inputFile.endsWith(".pdf")) {
			System.out.println("文件格式不是pdf");
			return;
		}
		if (!pdfFile.exists()) {
			System.out.println("pdf 文件已存在！");
			return;
		}
		if (swfFile.exists()) {
			System.out.println("swf 文件已存在！");
			return;
		}
		// 进行转换
		try {
			/*
			 * languagedir=D:\\xpdf-chinese-simplified 用于处理pdf 转换时出现的乱码 处理pdf
			 * 转换的乱码需要进行三步 
			 * 1  下载XPDF：ftp://ftp.foolabs.com/pub/xpdf/xpdf-chinese-simplified
			 * .tar.gz 解压到 D:\xpdf-chinese-simplified
			 * 2  下载字体:http://blog.pjoke.com/wp-content/uploads/2009/02/font.zip
			 * 解压到 D:\xpdf-chinese-simplified\CMap\ 
			 * 3  配置打开并修改xpdf-chinese-simplified 目录下的add-to-xpdfrc
			 * 文件。将里面的路径设为自己的路径：
			 */
			String command = PDF2SWF_PATH + " \"" + inputFile + "\" -o "
					+ swfFile
					+ " -T 9 -s languagedir=D:\\xpdf-chinese-simplified";// -s
																			// languagedir=D:\\xpdf-chinese-simplified
																			// 是用来处理转换时出现的中文乱码
			System.out.println("开始转换文档: " + inputFile);
			Runtime.getRuntime().exec(command);
			System.out.println("成功转换为SWF 文件！");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("转换文档为swf 文件失败！");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertPdf c = new convertPdf();
		String inputFile = "d:/resource/一个PS进阶的教程_对新手老手都有帮助.pdf";
		String outputFile = "d:/resource/一个PS进阶的教程_对新手老手都有帮助.swf";
		c.convertPDF(inputFile, outputFile);
	}
}
