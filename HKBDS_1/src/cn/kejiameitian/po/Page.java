package cn.kejiameitian.po;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

//封装页面数据
public class Page {

	private List list;
	private int totalPage;  //记住总页数

	private int totalRecord;
	private int pageSize ;    //每页显示的数量


	private int pageNum;   //代表用户想看的页
	private int startIndex;  //代表用户想看的页的数据从数据库哪个地方开始取


	private int startPage;  //记住jsp页面显示的起始页码
	private int endPage;  //记往jsp页面显示的结束页码

	private String url;   //记住用于处理分页的servlet

	public Page(int totalRecord,int pageNum,int pageSize){
		this.totalRecord = totalRecord;
        this.pageSize = pageSize;
		if(this.totalRecord%this.pageSize==0){
			this.totalPage = this.totalRecord/this.pageSize;
		}else{
			this.totalPage = this.totalRecord/this.pageSize + 1;
		}

		this.pageNum = pageNum;  //1
		this.startIndex = (this.pageNum-1)*this.pageSize;


		//根据用户想看的页pagenum，算出jsp页面的起始和结束页码
		if(this.totalPage<=10){
			this.startPage = 1;
			this.endPage = this.totalPage;
		}else{
			//20   18
			this.startPage = this.pageNum -4;
			this.endPage = this.pageNum + 5;

			if(this.startPage<1){
				this.startPage = 1;
				this.endPage = 10;
			}

			if(this.endPage > this.totalPage){
				this.endPage = this.totalPage;
				this.startPage = this.totalPage-9;
			}


		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}




	public int getStartPage() {
		return startPage;
	}



	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}



	public int getEndPage() {
		return endPage;
	}



	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}



	public List getList() {
		return list;
	}



	public void setList(List list) {
		this.list = list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}


}
