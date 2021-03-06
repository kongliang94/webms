package com.kongl.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class IndexController extends BaseController{
	
	@RequestMapping("/index")
	public String toIndex(Model model){
		model.addAttribute("currentUser",getCurrentLoginName());
		return "main/index";
	}
	
	@RequestMapping("/home")
	public String toHome(){
		return "main/home";
	}

}
