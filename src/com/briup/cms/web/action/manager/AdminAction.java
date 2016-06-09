package com.briup.cms.web.action.manager;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Admin;
import com.briup.cms.service.IAdminService;
import com.briup.cms.service.impl.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IAdminService adminService = 
						new AdminServiceImpl<Object>();

	private List<Admin> adminList;
	
	private Admin admin;
	private Long id;
	private String name;
	private String password;
	
	@Action(value="toAddAdmin",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/addAdmin.jsp")})
	public String toAddAdmin(){
		return SUCCESS;
	}

	@Action(value="toAdminManager",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/adminManager.jsp")})
	public String toAdminManager(){
		adminList = adminService.list();
		return SUCCESS;
	}
	
	@Action("addAdmin")
	public void addAdmin(){
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(password);
		adminService.add(admin);
	}

	@Action("delAdmin")
	public void delAdmin(){
		adminService.delete(id);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Action(value="toUpdAdmin",
			results={@Result(name="success",location="/WEB-INF/jsp/manager/updAdmin.jsp")})
	public String toUpdAdmin(){
		admin=adminService.findById(id);
		return SUCCESS;//"success"
	}

	@Action(value="updAdmin")
	public void updAdmin(){
		//将接收到的参数进行封装，封装为一个对象
		Admin admin = new Admin();
		admin.setId(id);
		admin.setName(name);
		admin.setPassword(password);
		adminService.update(admin);
	}

	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
