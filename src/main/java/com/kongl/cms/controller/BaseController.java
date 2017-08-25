package com.kongl.cms.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kongl.cms.domain.vo.User;



@Controller
@Scope("prototype")
public class BaseController {
	
	protected Log log=LogFactory.getLog(getClass());
	
	
	/**
     * 登录用户名
     */
    public String getCurrentLoginName() {
        Subject currentUser = SecurityUtils.getSubject();
        User user = currentUser.getPrincipals().oneByType(User.class);
        return user.getUserLoginName();
    }
}
