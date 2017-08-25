package com.kongl.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class IndexController {
	
	@RequestMapping("/index")
	public String toIndex(){
		return "main/index";
	}
	
	@RequestMapping("/home")
	public String toHome(){
		return "main/home";
	}

}
