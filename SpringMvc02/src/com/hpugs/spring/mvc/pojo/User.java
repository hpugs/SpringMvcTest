package com.hpugs.spring.mvc.pojo;

import java.util.Date;

public class User {

	private Integer id;
	private String name;
	private Integer age;
	private Date createTime;
	private String remark;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer id, String name, Integer age, Date createTime, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.createTime = createTime;
		this.remark = remark;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
