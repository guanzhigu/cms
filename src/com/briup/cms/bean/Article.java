package com.briup.cms.bean;

import java.util.Date;

public class Article {
	private Long id;		//编号
	private String title;	//标题
	private String author;
	private String content;	//内容
	private Date publisurDate;	//发布日期
	private Long c_id;//外键  该文章属于哪个栏目
	
	public Article() {
	}
	
	public Article(Long id, String title, String author, String content,
			Date publisurDate, Long c_id) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.publisurDate = publisurDate;
		this.c_id = c_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublisurDate() {
		return publisurDate;
	}
	public void setPublisurDate(Date publisurDate) {
		this.publisurDate = publisurDate;
	}
	public Long getC_id() {
		return c_id;
	}
	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
