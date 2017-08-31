package com.kongl.cms.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kongl.cms.common.constant.ResultCode;
import com.kongl.cms.controller.BaseController;
import com.kongl.cms.domain.bo.ResultInfo;
import com.kongl.cms.domain.vo.Role;
import com.kongl.cms.domain.vo.User;
import com.kongl.cms.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{

	@Autowired
	private RoleService roleService;
	@RequestMapping("/role_list")
	public String roleList(){
		return "system/role_list";
	}
    @RequestMapping("/ajax_role_list")
    @ResponseBody
    public String ajaxUserList(Role role){
       return roleService.selectRoleResultPageList(role);
    }

    @RequestMapping("/role_add")
    public String toAdd(Model model){
        model.addAttribute("pageFlag", "addPage");
        return "system/role_edit";
    }
    
    
    @RequestMapping("/ajax_save_role")
    @ResponseBody
    public ResultInfo ajaxSaveRole(Role role){
        try {
			return roleService.saveOrUpdateRole(role, getCurrentLoginName());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("保存角色异常");
			return ResultInfo.returnCodeMessage(ResultCode.ROLE_SAVE_ERROR);
		}
    }
    
    @RequestMapping("/role_update")
    public String toUpdate(Model model,Integer roleId){
        model.addAttribute("pageFlag", "updatePage");
        model.addAttribute("role",roleService.selectRoleById(roleId));
        return "system/role_edit";
    }
}
