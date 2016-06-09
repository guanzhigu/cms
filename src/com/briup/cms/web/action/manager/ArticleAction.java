package com.briup.cms.web.action.manager;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.service.IArticleService;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.ArticleServiceImpl;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private ICategoryService categoryService
						= new CategoryServiceImpl();
	private IArticleService articleService = 
						new ArticleServiceImpl<Object>();
	
	private List<Category> categoryList;
	private List<Article> articleList;
	
	private Article article;
	private Long id;
	private String title;
	private String author;
	private String content;
	private Long c_id;
	private Date publisurDate;
	
	/**
	 * 跳转到添加文章页面
	 * */
	@Action(value="toAddArticle",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/addArticle.jsp")})
	public String toAddArticle(){
		categoryList = categoryService.list();
		return SUCCESS;
	}
	
	/**
	 * 跳转到栏目管理页面
	 * */
	@Action(value="toArticleManager",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/articleManager.jsp")})
	public String toArticleManager(){
		//查询所有文章的信息
		articleList = articleService.list();
		return SUCCESS;
	}
	
	/**
	 * 添加文章
	 * */
	@Action("addArticle")
	public void addArticle(){
		Article article = new Article();
		article.setAuthor(author);
		article.setC_id(c_id);
		article.setContent(content);
		article.setPublisurDate(new Date());
		article.setTitle(title);
		articleService.add(article);
	}
	
	/**
	 * 删除文章
	 * */
	@Action("delArticle")
	public void delArticle(){
		articleService.delete(id);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 跳转到修改新闻页面
	 * */
	@Action(value="toUpdArticle",
			results={@Result(name="success",location="/WEB-INF/jsp/manager/updArticle.jsp")})
	public String toUpdArticle(){
		categoryList = categoryService.list();
	    article=articleService.findById(id);
		return SUCCESS;//"success"
	}
	/**
	 * 修改栏目
	 */
	@Action(value="updArticle")
	public void updArticle(){
		//将接收到的参数进行封装，封装为一个对象
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setAuthor(author);
		article.setContent(content);
		article.setPublisurDate(publisurDate);
		//调用sercice层的服务，完成添加栏目的功能
		articleService.update(article);
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
}
