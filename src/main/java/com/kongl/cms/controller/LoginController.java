package com.kongl.cms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kongl.cms.common.constant.ResultCode;
import com.kongl.cms.domain.bo.ResultInfo;

@Controller
public class LoginController extends BaseController{

	
	
	@RequestMapping("/loginProxy")
	public String loginProxy(){
		return "main/loginProxy";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	@ResponseBody
	public ResultInfo loginCheck(String username, String password){
		//System.out.println(11);
		log.info("登陆验证处理开始");
		long startTime=System.currentTimeMillis();
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		token.setRememberMe(true);
		
		Subject currentUser=SecurityUtils.getSubject();
		currentUser.login(token);
		if (currentUser.isAuthenticated()) {
			return ResultInfo.returnCodeMessage(ResultCode.GLOBAL_SUCCESS);
        }
        return ResultInfo.returnCodeMessage(ResultCode.GLOBAL_LOGIN_FAIL);
		
	}
}
