package com.hpugs.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hpugs.spring.mvc.pojo.Article;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	public static List<Article> articles = new ArrayList<Article>();
	
	static{
		for(int i=0; i<10; i++){
			articles.add(new Article(i+1, "标题"+i, "详情"+i));
		}
	}

	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("articles", articles);
		return "article/list";
	}
	
	@RequestMapping("/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView();
		for (Article article : articles) {
			if(id == article.getId()){
				modelAndView.addObject("article", article);
				break;
			}
		}
		modelAndView.setViewName("article/detail");
		return modelAndView;
	}
	
}
