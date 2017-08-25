package com.kongl.cms.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kongl.cms.domain.vo.Resource;
import com.kongl.cms.service.ResourceService;

@Controller
@RequestMapping("/res")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	
	/**
     * 加载资源列表List
     * @param resource
     * @return
     */
    @RequestMapping("/ajax_res_list")
    @ResponseBody
    public String ajaxResourceList(Resource resource){
        return resourceService.selectResourceResultPageList(resource);
    }
	
	@RequestMapping("/ajax_res_menu_top")
    @ResponseBody
    public String ajaxResMenuTop(){
        return resourceService.selectResMenuTop();
    } 
	
	@RequestMapping("/ajax_res_menu_left")
	@ResponseBody
	public String ajaxResMenuLeft(Integer resParentid){
		return resourceService.selectResLevelListByParentid(resParentid);
	}
}
