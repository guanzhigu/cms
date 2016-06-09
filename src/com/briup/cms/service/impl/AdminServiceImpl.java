package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Admin;
import com.briup.cms.bean.Category;
import com.briup.cms.dao.AdminDao;
import com.briup.cms.service.IAdminService;

public class AdminServiceImpl<admin> implements IAdminService {

	private AdminDao adminDao = new AdminDao();
	
	@Override
	public void add(Admin admin) {
		adminDao.save(admin);
	}

	@Override
	public List<Admin> list() {
		List<Admin> list = adminDao.findAll();
		return list;
	}
	/**
	 * 浏览文章
	 * */
	@Override
	public Admin scanner(long id) {
		List<Admin> list = adminDao.query(id, null);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public void delete(long id) {
		adminDao.deleteById(id);
	}

	@Override
	public Admin findById(long id) {
		return adminDao.findById(id);
	}

	@Override
	public void update(Admin admin) {
		adminDao.update(admin);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminDao.findAll();
	}
}
