package cn.kejiameitian.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.kejiameitian.Exception.ErrorException;

/**
 * @author linhao007
 * @param <IPTimeStamp>
 * @see 这是对外文件上传的工具类
 * 
 */
public class UploadUtil {
	private String path;
	private HttpServletRequest request = null;
	private List<FileItem> items = null;// 保存全部上传的内�?
	private Map<String, List<String>> params = new HashedMap();// 保存�?��参数
	private Map<String, FileItem> files = new HashedMap();
	private int maxSize;// 默认上传文件大小�?MB�?*1024*1024
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public List<FileItem> getItems() {
		return items;
	}
	public void setItems(List<FileItem> items) {
		this.items = items;
	}
	public Map<String, List<String>> getParams() {
		return params;
	}

	public void setParams(Map<String, List<String>> params) {
		this.params = params;
	}

	public Map<String, FileItem> getFiles() {
		return files;
	}

	public void setFiles(Map<String, FileItem> files) {
		this.files = files;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @Author linhao007
	 * @Decration 将Excel文件上传并返回该文件在服务器下的路径
	 * @param request
	 * @param path
	 * @return 上传文件的路径，方便读取里面的信�?
	 */
	public static String getUploadUtilFile(HttpServletRequest request,
			String path) {
		String flag = null;
		System.out.println("path=" + path);
		try {
			DiskFileItemFactory fileFactory = new DiskFileItemFactory();// 创建磁盘工厂
			ServletFileUpload fu = new ServletFileUpload(fileFactory);// 创建处理工具
			List fileItems = fu.parseRequest(request);// 接受全部的内�?
			Iterator iter = fileItems.iterator();// 将内容变成iterator实例
			List<String> fileNames = new ArrayList<String>();// 用来支持多个excel文件的上�?
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();// 取出每个文件的全部内容以及上传的内容
				if (!item.isFormField()) { // 判断是否为上传文�?
					String oldFileName = item.getName();
					String newFileName = null;
					int delimiter = oldFileName.lastIndexOf("/");
					if (delimiter == -1) {
						newFileName = oldFileName.substring(delimiter + 1);
					} else {
						newFileName = oldFileName;
					}
					fileNames.add(newFileName);
					String filepath = path + newFileName;
					item.write(new File(filepath));
					flag = filepath;
				} else { // 表单
					String fieldName = item.getFieldName();
				}
			}
			return flag;
		} catch (Exception e) {
			throw new ErrorException("文件上传失败");
		}
	}

	public UploadUtil(HttpServletRequest request, int maxSize, String path) {
		this.request = request;
		this.path = path;
		DiskFileItemFactory factory = new DiskFileItemFactory();// 创建磁盘工厂
		/*if (path != null) {// 判断是否�?��进行临时上传目录
			factory.setRepository(new File(path));// 设置临时保存目录
		}*/
		ServletFileUpload upload = new ServletFileUpload(factory);// 创建处理工具
		upload.setHeaderEncoding("UTF-8");
		if (maxSize > 0) {
			this.maxSize = maxSize;
		}
		upload.setFileSizeMax(this.maxSize);
		try {
			this.items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new ErrorException("文件上传错误");
		}
		this.init();
	}

	/**
	 * @Author linhao007
	 * @Decration 将所以参数保存在Map集合中，这个Map集合有两个参数，�?��参数params是保存全部的参数名称�?
	 *            而files是保存全部的上传文件，其中为了防止重命名的情况发生，�?��在此处直接上传的文件进行自动命名操作
	 */
	private void init() {
		// TODO Auto-generated method stub
		Iterator<FileItem> iter = this.items.iterator();
		int i=1;
		while (iter.hasNext()) {
			FileItem item = iter.next();// 取出每个上传的文�?
			if (item.isFormField()) {// 判断是否是普通文本参�?
				String name = item.getFieldName();// 取得表单名称
				String value = item.getString();// 取得表单内容
				List<String> temp = null;// 保存上传的内�?
				if (this.params.containsKey(name)) {// 判断内容是都已经存在
					temp = this.params.get(name);// 存在就取�?
				} else {
					temp = new ArrayList<String>();// 从新�?��List数组
				}
				temp.add(value);
				this.params.put(name, temp);
			} else {
				String name = item.getName();
				if(name.equals("")||name == null){
					
				}else{
					String extName = name.split("\\.")[1];
					Date date = new Date();
					String date1=String.valueOf(date.getTime());
					String fileName =String.valueOf(i)+date1+ "." + extName;
					try {
						item.write(new File(path+fileName));
					} catch (Exception e) {
						e.printStackTrace();
						// TODO Auto-generated catch block
						throw new ErrorException("文件上传失败");
					}
					this.files.put(path+fileName, item);
				}
			}
			i++;
		}
	}

	/**
	 * @Author linhao007
	 * @Decration 取出每一个参数的内容
	 * @param name
	 * @return
	 */
	public String getParameter(String name) {
		String ret = null;
		List<String> temp = this.params.get(name);
		if (temp != null) {
			ret = temp.get(0);
		}
		return ret;
	}

	/**
	 * @Author linhao007
	 * @Decration 对于是一组参数，则会将全部的内容保存成一个List集合
	 * @param name
	 * @return
	 */
	public String[] getParameterValues(String name) {
		String ret[] = null;
		List<String> temp = this.params.get(name);
		if (temp != null) {
			ret = temp.toArray(new String[] {});
		}
		return ret;
	}

	/**
	 * @Author linhao007
	 * @Decration 取出已经全部上传的文件并返回
	 * @return
	 */
	public Map<String, FileItem> getUploadFiles() {
		return this.files;
	}

	/**
	 * @Author linhao007
	 * @Decration 保存全部文件，并把文件名返回
	 * @param path
	 * @return
	 *//*
	public List<String> saveAll(String path) {// 保存全部文件，并返回文件名稱
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		if (this.files.size() > 0) {
			Set<String> keys = this.files.keySet();// 取得全部的key�?
			Iterator<String> iter = keys.iterator();// 實例化Iterator對象
			File saveFile = null;
			InputStream input = null;
			OutputStream out = null;
			while (iter.hasNext()) {
				FileItem item = this.files.get(iter.next());
				String fileName = new IPTimeStamp(this.request.getRemoteAddr())
						.getIPTimeStampRand()
						+ "."
						+ item.getName().split("\\.")[1];
				saveFile = new File(path + fileName);
				names.add(fileName);
				try {
					input = item.getInputStream();// 取得InputStream
					out = new FileOutputStream(saveFile);// 定义输出流保存文�?
					int temp = 0;
					byte data[] = new byte[512];// �?��空间分块保存
					while ((temp = input.read(data, 0, 512)) != -1) {// �?��读取内容
						out.write(data);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new ErrorException("保存文件失败");
				}// 取得InputStream
			}
		}
		return names;
	}*/

}
