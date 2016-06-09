package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.common.ConnectionFactory;
import com.briup.cms.model.CategoryModel;

public class ArticleDao {
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
				String sql = "delete from t_article where id = ?";
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
	public void save(Article article) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_article(title,content,author,publisurDate,c_id) values(?,?,?,?,?)";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getContent());
				pstmt.setString(3, article.getAuthor());
				// java.sql.Date java.util.Date
				long time = article.getPublisurDate().getTime();
				pstmt.setDate(4, new Date(time));
				pstmt.setLong(5, article.getC_id());
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
	public List<Article> findAll() {
		List<Article> list = new ArrayList<Article>();
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_article";
				// 2. 预处理
				pstmt = conn.prepareStatement(sql);
				// 3.执行
				rs = pstmt.executeQuery();
				while (rs.next()) {
					long id = rs.getLong("id");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String content = rs.getString("content");
					java.util.Date publisurDate = rs.getDate("publisurDate");
					long c_id = rs.getLong("c_id");
					Article a = new Article(id, title, author, content, publisurDate, c_id);
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

	public List<Article> query(Long id, String title, Long c_id) {
		List<Article> list = new ArrayList<Article>();
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_article where 1=1 ";
				if (id != null) {
					sql += "and id = " + id;
				}
				if (title != null) {
					sql += "and title like '%" + title + "%' ";
				}
				if (c_id != null) {
					sql += "and c_id = " + c_id;
				}
				System.out.println(sql);
				// 2. 预处理
				pstmt = conn.prepareStatement(sql);
				// 3.执行
				rs = pstmt.executeQuery();
				while (rs.next()) {
					long did = rs.getLong("id");
					String dtitle = rs.getString("title");
					String author = rs.getString("author");
					String content = rs.getString("content");
					Date date = rs.getDate("publisurDate");
					long dc_id = rs.getLong("c_id");

					Article article = new Article();
					article.setAuthor(author);
					article.setC_id(dc_id);
					article.setContent(content);
					article.setId(did);
					article.setPublisurDate(date);
					article.setTitle(dtitle);
					list.add(article);
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
	public void update(Article article) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "update t_article set title=?,author=?,content=?,publisurDate=?,c_id=? where id=?";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getAuthor());
				pstmt.setString(3, article.getContent());
				pstmt.setDate(4, (Date) article.getPublisurDate());
				pstmt.setLong(5,article.getC_id());
				pstmt.setLong(6, article.getId());
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
	public Article findById(long id) {
		Article article = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_article where id=?";
				// 2. 预处理
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				// 3.执行
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String title = rs.getString("title");
					String author = rs.getString("author");
					String content = rs.getString("content");
					java.util.Date publisurDate = rs.getDate("publisurDate");
					long c_id = rs.getLong("c_id");
					article = new Article(id, title, author, content, publisurDate, c_id);
					article.setId(id);
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
		return article;
	}
}
