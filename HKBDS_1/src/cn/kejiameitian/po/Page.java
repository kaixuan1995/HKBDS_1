package cn.kejiameitian.po;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

//��װҳ������
public class Page {

	private List list;
	private int totalPage;  //��ס��ҳ��

	private int totalRecord;
	private int pageSize ;    //ÿҳ��ʾ������


	private int pageNum;   //�����û��뿴��ҳ
	private int startIndex;  //�����û��뿴��ҳ�����ݴ����ݿ��ĸ��ط���ʼȡ


	private int startPage;  //��סjspҳ����ʾ����ʼҳ��
	private int endPage;  //����jspҳ����ʾ�Ľ���ҳ��

	private String url;   //��ס���ڴ����ҳ��servlet

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


		//�����û��뿴��ҳpagenum�����jspҳ�����ʼ�ͽ���ҳ��
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
