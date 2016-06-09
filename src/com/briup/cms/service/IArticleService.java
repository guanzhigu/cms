package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Article;

/**
 *文章管理的业务逻辑
 * */
import com.briup.cms.model.CategoryModel;

public interface IArticleService {
	// 添加文章
	void add(Article article);
	// 查询
	List<Article> list();
	// 通过id查询
	List<Article> findAll();
	Article scanner(long id);
	// 通过id获取栏目信息
	Article findById(long id);
	// 修改栏目信息
	void update(Article article);
	// 通过栏目查询
	List<Article> listByCategory(long c_id);
	// 查询所有
	List<CategoryModel> listAll();
	// 删除文章
	void delete(long id);	
}
