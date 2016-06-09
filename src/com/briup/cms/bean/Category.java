package com.briup.cms.bean;
/**
 * 栏目
 * */
public class Category {
	//私有属性
	private Long id;
	private String name;
	private Integer code;
	
	//构造函数
	public Category() {
		
	}
	public Category(String name, Integer code) {
		super();
		this.name = name;
		this.code = code;
	}
	//setter,getter方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
