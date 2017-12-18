package com.hpugs.spring.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hpugs.spring.mvc.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static List<User> users = new ArrayList<User>();
	
	static{
		for (int i = 0; i < 3; i++) {
			users.add(new User(i+1, "item"+i, 25, new Date(), "模拟注册"));
		}
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/loginJsp")
	public String loginJsp(){
		return "login";
	}
	
	/**
	 * 登录接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		String name = (String) request.getParameter("name");
		String pwd = (String) request.getParameter("pwd");
		if("abc".equals(name) && "123".equals(pwd)){
			Cookie cookie = new Cookie("userInfo", name + "-" + pwd);
			cookie.setMaxAge(24 * 60 * 60 * 1);
			response.addCookie(cookie);
			HttpSession session = request.getSession();
			session.setAttribute("userName", name);
			return "success";
		}
		return "redirect:/user/loginJsp.action";
	}

	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", users);
		modelAndView.setViewName("user/list");
		return modelAndView;
	}
	
	/**
	 * 用户JSON格式数据
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/listJson")
	public void listJson(HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(JSON.toJSONString(users));
		writer.flush();
		writer.close();
	}
	
	/**
	 * 添加学生界面
	 * @param id
	 */
	@RequestMapping("/addJsp")
	public ModelAndView addJsp(@RequestParam(value="", required=false) String id){
		ModelAndView modelAndView = new ModelAndView();
		User resultUser = new User();
		if(null != id){
			for (User user : users) {
				if(Integer.parseInt(id) == user.getId()){
					resultUser = user;
					break;
				}
			}
		}
		modelAndView.addObject("user", resultUser);
		modelAndView.setViewName("user/add");
		return modelAndView;
	}
	
	/**
	 * 添加学生接口
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	public String add(@ModelAttribute User user){
		//重定向
		String resultUrl = "redirect:/user/list.action";
		if(null != user.getId()){
			for (User item : users) {
				if(user.getId() == item.getId()){
					item.setAge(user.getAge());
					item.setCreateTime(user.getCreateTime());
					item.setName(user.getName());
					item.setRemark(user.getRemark());
					break;
				}
			}
		}else{
			user.setId(users.size()+1);
			user.setCreateTime(new Date());
			users.add(user);
			//转发
			resultUrl = "forward:/user/addJsp.action?id=" + user.getId();
		}
		return resultUrl;
	}
	
}
