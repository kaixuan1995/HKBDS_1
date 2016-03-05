package com.TestWord2Html.Util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobUtil {  
    
    // 8 代表word保存成html  
    public static final int WORD_HTML = 8;   
  
    /**
     * 可以实现将ppt以及doc转化为html，但是转化时间成本高且效果不好，只兼容Windows平台
     * @param args
     */
    public static void main(String[] args) {  
        String docfile = "D:\\resource\\三国\\三国演义.doc";  
        String htmlfile = "D:\\resource\\三国\\三国演义.html";  
        JacobUtil.wordToHtml(docfile, htmlfile);  
    }  
      
    /**   
     * WORD转HTML   
     * @param docfile WORD文件全路径   
     * @param htmlfile 转换后HTML存放路径   
     */    
    public static void wordToHtml(String docfile, String htmlfile)     
    {     
        // 启动word应用程序(Microsoft Office Word 2003)  
        ActiveXComponent app = new ActiveXComponent("Word.Application");  
        System.out.println("*****正在转换...*****");  
        try    
        {     
            // 设置word应用程序不可见    
            app.setProperty("Visible", new Variant(false));    
            // documents表示word程序的所有文档窗口，（word是多文档应用程序）  
            Dispatch docs = app.getProperty("Documents").toDispatch();    
            // 打开要转换的word文件  
            Dispatch doc = Dispatch.invoke(     
                    docs,     
                    "Open",     
                    Dispatch.Method,     
                    new Object[] { docfile, new Variant(false),   
                            new Variant(true) }, new int[1]).toDispatch();     
            // 作为html格式保存到临时文件  
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {     
                    htmlfile, new Variant(WORD_HTML) }, new int[1]);     
            // 关闭word文件  
            Dispatch.call(doc, "Close", new Variant(false));     
        }     
        catch (Exception e)     
        {     
            e.printStackTrace();     
        }     
        finally    
        {     
            //关闭word应用程序  
            app.invoke("Quit", new Variant[] {});     
        }   
        System.out.println("*****转换完毕********");  
    }  
}  
