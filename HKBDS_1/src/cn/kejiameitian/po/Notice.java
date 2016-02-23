package cn.kejiameitian.po;

/**
 * 通告实体类
 * @author zhu
 *
 */
public class Notice {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String n_item;
	private String notice;
	private String n_date;
	public String getN_item() {
		return n_item;
	}
	public void setN_item(String n_item) {
		this.n_item = n_item;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getN_date() {
		return n_date;
	}
	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	
}
