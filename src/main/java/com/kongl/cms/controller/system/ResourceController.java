package com.kongl.cms.controller.system;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     *跳转到资源列表页面
     * @return
     */
    @RequestMapping("/res_list")
    public String toResListPage() {
        return "system/res_list";
    }


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

    /**
     * 选择图标
     * @return
     */
    @RequestMapping("/res_img")
    public String toResImgPage() {
        return "system/res_img";
    }
    /**
     * 资源添加页面
     * @return
     */
    @RequestMapping("/res_add")
    public String toResAddPage(Model model,String resParentId) {
    	System.out.println(resParentId);
    	
    	model.addAttribute("resList", resourceService.selectResLevel2ListByParentid(Integer.parseInt(resParentId)));
        return "system/res_edit";
    }
    @RequestMapping("/res_edit")
    public String toResEditPage(Model model,Integer resId) {
    	model.addAttribute("res", resourceService.selectByPrimaryKey(resId));
        return "system/res_edit";
    }
	
	@RequestMapping("/ajax_res_menu_top")
    @ResponseBody
    public String ajaxResMenuTop(){
        return resourceService.selectResMenuTop();
    } 
	
	@RequestMapping("/ajax_res_menu_left")
	@ResponseBody
	public String ajaxResMenuLeft(Integer resParentid,HttpSession session){
		session.setAttribute("resMaxId", resParentid);
		String menu=resourceService.selectResLevelListByParentid(resParentid);
		//System.out.println(menu);
		return menu;
	}
}
