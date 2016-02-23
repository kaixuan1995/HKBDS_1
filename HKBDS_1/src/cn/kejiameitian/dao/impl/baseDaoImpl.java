package cn.kejiameitian.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.registry.infomodel.User;

import cn.kejiameitian.Exception.ErrorException;
import cn.kejiameitian.dao.baseDao;
import cn.kejiameitian.po.Admin;
import cn.kejiameitian.po.Message;
import cn.kejiameitian.po.Notice;
import cn.kejiameitian.po.Product;
import cn.kejiameitian.util.DBUtil;

public class baseDaoImpl implements baseDao {
	private Admin user;
	private Notice notice;
	private String sql = null;
	private boolean flag;
	private List<Notice> noticelist = null; 
	private List<Notice> noticetitlelist = null;
	private List<Product> productlist = null;
	private List<Message> messagelist = null;
	private List<Message> messagetitlelist = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private int id;
	private String category;
	private String querynotice;
	private String querymessage;
//	产品发布
	private Product product;
    private Message message;
	
	
    /*
     * 管理员登陆(non-Javadoc)
     * @see cn.kejiameitian.dao.baseDao#findEntity(cn.kejiameitian.po.Admin)
     */
	public Admin findEntity(Admin user) {
		// TODO Auto-generated method stub
		this.user = user;
		Admin user1 = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_admin  where admin=? and pasword=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getAdmin());
			stmt.setString(2, user.getPasword());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user1 = new Admin();
				user1.setAdmin(rs.getString(1));
				user1.setPasword(rs.getString(2));
				return user1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
		// ResultSet rs = DBUtil.getRs(pstmt);
		return user1;
	}

	
/*
 * 增加留言(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#Add(cn.kejiameitian.po.Message)
 */
	public boolean Add(Message message) {
		// TODO Auto-generated method stub
		this.message = message;
		flag = false;
		try {
			con = DBUtil.getConnection();
			sql = "insert into t_message(m_name,m_item,m_emil,m_address,m_date,m_message) values(?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, message.getM_name());
			stmt.setString(2, message.getM_item());
			stmt.setString(3, message.getM_emil());
			stmt.setString(4, message.getM_address());
			stmt.setString(5, message.getM_date());
			stmt.setString(6, message.getM_message());
			stmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
		return false;
	}

	/*
	 * 增加公告(non-Javadoc)
	 * @see cn.kejiameitian.dao.baseDao#Add(cn.kejiameitian.po.Notice)
	 */
	public boolean Add(Notice notice) {
		// TODO Auto-generated method stub
		this.notice = notice;
		flag = false;
		try {
			con = DBUtil.getConnection();
			sql = "insert into t_notice(n_item,notice,n_date) values(?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, notice.getN_item());
			stmt.setString(2, notice.getNotice());
			stmt.setString(3, notice.getN_date());
			stmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
		// ResultSet rs = DBUtil.getRs(pstmt);
		return flag;
	}
/*
 *   发布产品(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#Add(cn.kejiameitian.po.Product)
 */
	public boolean Add(Product product) {
		// TODO Auto-generated method stub
		this.product = product;
		flag = false;
		try {
			con = DBUtil.getConnection();
			sql = "insert into t_product(p_name,p_image,p_content,p_price,p_date,p_category) values(?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getP_name());
			stmt.setString(2, product.getP_image());
			stmt.setString(3, product.getP_content());
			stmt.setString(4, product.getP_price());
			stmt.setString(5, product.getP_date());
			stmt.setString(6, product.getP_category());
			stmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
		// ResultSet rs = DBUtil.getRs(pstmt);
		return flag;
	}

/*
 *  修改公告(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#Update(cn.kejiameitian.po.Notice)
 */
		public boolean Update(Notice notice) {
			// TODO Auto-generated method stub
						this.notice = notice;
						flag = false;
						try {
							con = DBUtil.getConnection();
							sql = "update t_notice SET n_item='" + notice.getN_item()
									+ "',notice='" + notice.getNotice() + "',n_date='"
									+ notice.getN_date() + "' where n_id=" + notice.getId();
							/*
							 * stmt.setString(1, notice.getN_item()); stmt.setString(2,
							 * notice.getNotice()); stmt.setInt(3, notice.getId());
							 */
							stmt = con.prepareStatement(sql);
							stmt.executeUpdate();
							flag = true;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw new ErrorException("数据库连接出错！");
						} finally {
							DBUtil.close(con);
						}
						// ResultSet rs = DBUtil.getRs(pstmt);
						return flag;
		}

/*
 * 修改产品(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#Update(cn.kejiameitian.po.Product)
 */
		public boolean Update(Product product) {
			// TODO Auto-generated method stub
						this.product = product;
						flag = false;
						try {
							con = DBUtil.getConnection();
							sql = "update t_product SET p_name='" + product.getP_name()
									+ "',p_image='" + product.getP_image() + "',p_content='"
									+ product.getP_content() + "',p_price='" + product.getP_price() + "',p_date='"+ product.getP_date() +"',p_category='"+ product.getP_category() +"' where p_id=" + product.getP_id();
							/*
							 * stmt.setString(1, notice.getN_item()); stmt.setString(2,
							 * notice.getNotice()); stmt.setInt(3, notice.getId());
							 */
							stmt = con.prepareStatement(sql);
							stmt.executeUpdate();
							flag = true;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw new ErrorException("数据库连接出错！");
						} finally {
							DBUtil.close(con);
						}
						// ResultSet rs = DBUtil.getRs(pstmt);
						return flag;
		}

	
	
	/*
	 * 删除留言(non-Javadoc)
	 * @see cn.kejiameitian.dao.baseDao#deleteMessage(int)
	 */
	public boolean deleteMessage(int id) {
		// TODO Auto-generated method stub
				this.id = id;
				try{
					con = DBUtil.getConnection();
					sql = "delete from t_message where m_id=" + id;
					stmt = con.prepareStatement(sql);
					stmt.executeUpdate();
					flag = true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ErrorException("数据库连接出错！");
				} finally {
					DBUtil.close(con);
				}
				// ResultSet rs = DBUtil.getRs(pstmt);
				return flag;
	}
	
	/*
	 * 删除公告(non-Javadoc)
	 * @see cn.kejiameitian.dao.baseDao#deleteNotice(int)
	 */
	public boolean deleteNotice(int id) {
		// TODO Auto-generated method stub
		this.id = id;
		try {
			con = DBUtil.getConnection();
			sql = "delete from t_notice where n_id=" + id;
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
		// ResultSet rs = DBUtil.getRs(pstmt);
		return flag;
	}

	/*
	 * 删除产品(non-Javadoc)
	 * @see cn.kejiameitian.dao.baseDao#deleteProduct(int)
	 */
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
				this.id = id;
				try {
					con = DBUtil.getConnection();
					sql = "delete from t_product where p_id=" + id;
					stmt = con.prepareStatement(sql);
					stmt.executeUpdate();
					flag = true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ErrorException("数据库连接出错！");
				} finally {
					DBUtil.close(con);
				}
				// ResultSet rs = DBUtil.getRs(pstmt);
				return flag;
	}

	/*
	 * 查询所有公告(non-Javadoc)
	 * @see cn.kejiameitian.dao.baseDao#findEntity()
	 */
		public List<Notice> findEntity() {
			// TODO Auto-generated method stub
			noticelist = new ArrayList<Notice>();
			try {
				con = DBUtil.getConnection();
				String sql = "select * from t_notice";
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					Notice notice = new Notice();
					notice.setId(rs.getInt(1));
					notice.setN_item(rs.getString(2));
					notice.setNotice(rs.getString(3));
					notice.setN_date(rs.getString(4));
					noticelist.add(notice);
				}
				return noticelist;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ErrorException("数据库连接出错！");
			} finally {
				DBUtil.close(con);
			}
			// ResultSet rs = DBUtil.getRs(pstmt);
		}
		
	
	/*
	 * 查询指定id的公告(non-Javadoc)
	 * @see cn.kejiameitian.dao.baseDao#findEntity(int)
	 */
	public Notice findEntity(int id) {
		// TODO Auto-generated method stub
		this.id = id;
		try {
			con = DBUtil.getConnection();
			sql = "select * from t_notice where n_id=" + id;
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			Notice notice = new Notice();
			while (rs.next()) {
				notice.setId(rs.getInt(1));
				notice.setN_item(rs.getString(2));
				notice.setNotice(rs.getString(3));
				notice.setN_date(rs.getString(4));
			}
			return notice;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
		// ResultSet rs = DBUtil.getRs(pstmt);
	}
	/*
	 * 模糊查询标题 公告信息(non-Javadoc)
	 * @see cn.kejiameitian.dao.baseDao#findNoticeEntity(java.lang.String)
	 */
	public List<Notice> findNoticeEntity(String querynotice) {
		// TODO Auto-generated method stub
		noticetitlelist = new ArrayList<Notice>();
				this.querynotice = querynotice;
				try {
					con = DBUtil.getConnection();
					sql = "select * from t_notice where n_item like '%"+querynotice+"%' ";
					stmt = con.prepareStatement(sql);
					rs = stmt.executeQuery();
					
					while (rs.next()) {
						Notice notice = new Notice();
						notice.setId(rs.getInt(1));
						notice.setN_item(rs.getString(2));
						notice.setNotice(rs.getString(3));
						notice.setN_date(rs.getString(4));
						noticetitlelist.add(notice);
					}
					return noticetitlelist;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ErrorException("数据库连接出错！");
				} finally {
					DBUtil.close(con);
				}
	}


/*
 * 	查看全部的产品(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#findProductEntity()
 */
	public List<Product> findProductEntity() {
		productlist = new ArrayList<Product>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_product";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setP_id(rs.getInt(1));
				product.setP_name(rs.getString(2));
				product.setP_image(rs.getString(3));
				product.setP_content(rs.getString(4));
				product.setP_price(rs.getString(5));
				product.setP_date(rs.getString(6));
				product.setP_category(rs.getString(7));
				productlist.add(product);
			}
			return productlist;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
		// ResultSet rs = DBUtil.getRs(pstmt);
	}

	/*
	 * 查询指定id的产品(non-Javadoc)
	 * @see cn.kejiameitian.dao.baseDao#findProductEntity(int)
	 */
	public Product findProductEntity(int id) {
		// TODO Auto-generated method stub
				this.id = id;
				try {
					con = DBUtil.getConnection();
					sql = "select * from t_product where p_id=" + id;
					stmt = con.prepareStatement(sql);
					rs = stmt.executeQuery();
					Product product = new Product();
					while (rs.next()) {
						product.setP_id(rs.getInt(1));
						product.setP_name(rs.getString(2));
						product.setP_image(rs.getString(3));
						product.setP_content(rs.getString(4));
						product.setP_price(rs.getString(5));
						product.setP_date(rs.getString(6));
						product.setP_category(rs.getString(7));
					}
					return product;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ErrorException("数据库连接出错！");
				} finally {
					DBUtil.close(con);
				}
				// ResultSet rs = DBUtil.getRs(pstmt);
	}
	
    /*
     * 查询指定类型（p_category）的产品(non-Javadoc)
     * @see cn.kejiameitian.dao.baseDao#findProductEntity(java.lang.String)
     */
	public List<Product> findProductEntity(String category) {
		productlist = new ArrayList<Product>();
		// TODO Auto-generated method stub
				this.category = category;
				try {
					con = DBUtil.getConnection();
				    sql = "select * from t_product where p_category='" + category +"'";
					stmt = con.prepareStatement(sql);
					rs = stmt.executeQuery();
					while (rs.next()) {
						Product product = new Product();
						product.setP_id(rs.getInt(1));
						product.setP_name(rs.getString(2));
						product.setP_image(rs.getString(3));
						product.setP_content(rs.getString(4));
						product.setP_price(rs.getString(5));
						product.setP_date(rs.getString(6));
						product.setP_category(rs.getString(7));
						productlist.add(product);
					}
					return productlist;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ErrorException("数据库连接出错！");
				} finally {
					DBUtil.close(con);
				}
				// ResultSet rs = DBUtil.getRs(pstmt);
	}
	
/*
 * 查询所有留言(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#findMessageEntity()
 */
	public List<Message> findMessageEntity() {
		messagelist = new ArrayList<Message>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_message";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				message.setM_id(rs.getInt(1));
				message.setM_name(rs.getString(2));
				message.setM_item(rs.getString(3));
				message.setM_emil(rs.getString(4));
				message.setM_address(rs.getString(5));
				message.setM_date(rs.getString(6));
				message.setM_message(rs.getString(7));
				messagelist.add(message);
			}
			return messagelist;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
		// ResultSet rs = DBUtil.getRs(pstmt);
	}

/*
 * 查询指定id的留言(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#findMessageEntity(int)
 */
	public Message findMessageEntity(int id) {
		this.id = id;
		try {
			con = DBUtil.getConnection();
			sql = "select * from t_message where m_id=" + id;
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			Message message = new Message();
			while (rs.next()) {
				message.setM_id(rs.getInt(1));
				message.setM_name(rs.getString(2));
				message.setM_item(rs.getString(3));
				message.setM_emil(rs.getString(4));
				message.setM_address(rs.getString(5));
				message.setM_date(rs.getString(6));
				message.setM_message(rs.getString(7));
			}
			return message;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
	}
	
/*
 * 对留言按照标题进行模糊查询(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#findMessageEntity(java.lang.String)
 */
	public List<Message> findMessageEntity(String querymessage) {
		// TODO Auto-generated method stub
		messagetitlelist = new ArrayList<Message>();
		this.querymessage = querymessage;
		try {
			con = DBUtil.getConnection();
			sql = "select * from t_message where m_item like '%"+querymessage+"%' ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Message message = new Message();
				message.setM_id(rs.getInt(1));
				message.setM_name(rs.getString(2));
				message.setM_item(rs.getString(3));
				message.setM_emil(rs.getString(4));
				message.setM_address(rs.getString(5));
				message.setM_date(rs.getString(6));
				message.setM_message(rs.getString(7));
				messagetitlelist.add(message);
			}
			return messagetitlelist;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
	}


/*
 * 留言分页(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#getPageData(int, int)
 */
	public List<Message> getPageData(int startIndex, int pageSize) {
		
		messagelist = new ArrayList<Message>();
		try {
			con = DBUtil.getConnection();
			sql = "select m_id, m_name, m_item, m_emil, m_address, m_date, m_message from t_message limit ?, ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, startIndex);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				message.setM_id(rs.getInt(1));
				message.setM_name(rs.getString(2));
				message.setM_item(rs.getString(3));
				message.setM_emil(rs.getString(4));
				message.setM_address(rs.getString(5));
				message.setM_date(rs.getString(6));
				message.setM_message(rs.getString(7));
				messagelist.add(message);
			}
			return messagelist;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
	}

	public int getTotalRecord() {
		try {
			con = DBUtil.getConnection();
System.out.println(con);
			sql = "select count(*) sum from t_message";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return rs.getInt("sum");
			}
			return 0;
	      } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ErrorException("数据库连接出错！");
			} finally {
				DBUtil.close(con);
			}
		}

/*
 * 产品前台显示分页(non-Javadoc)
 * @see cn.kejiameitian.dao.baseDao#getProductPageData(int, int)
 */
	public List<Product> getProductPageData(int startIndex, int pageSize,String category) {
		productlist = new ArrayList<Product>();
		try {
			con = DBUtil.getConnection();
			sql = "select *from t_product where p_category like '%"+category+"%' limit ?,?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, startIndex);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setP_id(rs.getInt(1));
				product.setP_name(rs.getString(2));
				product.setP_image(rs.getString(3));
				product.setP_content(rs.getString(4));
				product.setP_price(rs.getString(5));
				product.setP_date(rs.getString(6));
				product.setP_category(rs.getString(7));
				productlist.add(product);
			}
			return productlist;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException("数据库连接出错！");
		} finally {
			DBUtil.close(con);
		}
	}


	public int getProductTotalRecord(String category) {
		try {
			con = DBUtil.getConnection();
System.out.println(con);
			sql = "select count(*) sum from t_product where p_category like '%"+category+"%'";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return rs.getInt("sum");
			}
			return 0;
	      } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ErrorException("数据库连接出错！");
			} finally {
				DBUtil.close(con);
			}
	}
	
}
