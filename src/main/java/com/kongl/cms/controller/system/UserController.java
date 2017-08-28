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
import com.kongl.cms.service.UserService;



@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@RequestMapping("/user_list")
	public String userList(){
		return "system/user_list";
	}
	
	 /**
     * 加载用户列表List
     * @param user
     * @return
     */
    @RequestMapping("/ajax_user_list")
    @ResponseBody
    public String ajaxUserList(User user){
        return userService.selectUserResultPageList(user);
    }

    @RequestMapping("/user_add")
    public String toAdd(Model model){
    	//新增页面标识
        model.addAttribute("pageFlag", "addPage");
        return "system/user_edit";
    }
    
    
    @RequestMapping("/ajax_save_user")
    @ResponseBody
    public ResultInfo ajaxSaveUser(User user){
        try {
			return userService.saveOrUpdateUser(user, getCurrentLoginName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("保存用户异常");
			return ResultInfo.returnCodeMessage(ResultCode.USER_SAVE_ERROR);
		}
    }
    
    @RequestMapping("/user_update")
    public String toUpdate(Model model,Integer userId){
    	//新增页面标识
        model.addAttribute("pageFlag", "updatePage");
        User user=userService.selectUserById(userId);        
        model.addAttribute("user", user);
        return "system/user_edit";
    }
    
    @RequestMapping("/user_grant")
    public String toGrant(Model model,Integer userId){
        User user=userService.selectUserById(userId);        
        model.addAttribute("user", user);
        return "system/user_grant";
    }
    
   /* @RequestMapping("/ajax_undistributed_role_list")
    @ResponseBody
    public Role ajaxUndistributedRoleList(User user){
        
    }*/
}
