package com.hpugs.spring.mvc.pojo;

public class Article {
	
	private Integer id;
	private String title;
	private String context;
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(Integer id, String title, String context) {
		super();
		this.id = id;
		this.title = title;
		this.context = context;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
}
