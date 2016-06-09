package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Admin;

/**
 *文章管理的业务逻辑
 * */
import com.briup.cms.model.CategoryModel;

public interface IAdminService {
	
	void add(Admin admin);
	// 查询
	List<Admin> list();
	// 通过id查询
	List<Admin> findAll();
	Admin scanner(long id);
	
	Admin findById(long id);
	
	void update(Admin admin);
	
	void delete(long id);	
}
