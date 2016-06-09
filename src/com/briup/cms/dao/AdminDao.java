package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Admin;
import com.briup.cms.common.ConnectionFactory;
import com.briup.cms.model.CategoryModel;

public class AdminDao {
	/**
	 * 删除
	 */
	public void deleteById(long id) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "delete from t_admin where id = ?";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				// 3.执行sql
				pstmt.executeUpdate();
			} finally {
				// 4.释放资源
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存
	 * 
	 * @param 文章
	 */
	public void save(Admin admin) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_admin(name,password) values(?,?)";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, admin.getName());
				pstmt.setString(2, admin.getPassword());
		
				// 3.执行sql
				pstmt.executeUpdate();
			} finally {
				// 4.释放资源
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有
	 */
	public List<Admin> findAll() {
		List<Admin> list = new ArrayList<Admin>();
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_admin";
				// 2. 预处理
				pstmt = conn.prepareStatement(sql);
				// 3.执行
				rs = pstmt.executeQuery();
				while (rs.next()) {
					long id = rs.getLong("id");
					String name = rs.getString("name");
					String password = rs.getString("password");
					Admin a = new Admin(id, name, password);
					a.setId(id);
					list.add(a);
				}
			} finally {
				// 4.释放资源
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Admin> query(Long id, String name) {
		List<Admin> list = new ArrayList<Admin>();
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_admin where 1=1 ";
				if (id != null) {
					sql += "and id = " + id;
				}
				if (name != null) {
					sql += "and title like '%" + name + "%' ";
				}
				System.out.println(sql);
				// 2. 预处理
				pstmt = conn.prepareStatement(sql);
				// 3.执行
				rs = pstmt.executeQuery();
				while (rs.next()) {
					long did = rs.getLong("id");
					String dname= rs.getString("name");
				
					Admin admin = new Admin();
					admin.setName(name);
					list.add(admin);
				}
			} finally {
				// 4.释放资源
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 修改
	 */
	public void update(Admin admin) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "update t_admin set name=?,password=? where id=?";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, admin.getName());
				pstmt.setString(2, admin.getPassword());
				pstmt.setLong(3, admin.getId());
				// 3.执行sql
				pstmt.executeUpdate();
			} finally {
				// 4.释放资源
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过id查询
	 */
	public Admin findById(long id) {
		Admin admin = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_admin where id=?";
				// 2. 预处理
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				// 3.执行
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String name = rs.getString("name");
					String password = rs.getString("password");
					admin = new Admin(id, name, password);
					admin.setId(id);
				}
			} finally {
				// 4.释放资源
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}
