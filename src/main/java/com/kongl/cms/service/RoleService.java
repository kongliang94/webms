package com.kongl.cms.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kongl.cms.common.constant.ResultCode;
import com.kongl.cms.dao.RoleMapper;
import com.kongl.cms.domain.bo.ResultInfo;
import com.kongl.cms.domain.vo.Role;
import com.kongl.cms.utils.ParseObjectUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class RoleService {

    private Log log = LogFactory.getLog(RoleService.class);


    @Autowired
    private RoleMapper roleMapper;


    /**
     * 根据角色Id查询角色信息
     *
     * @param roleId 角色Id
     * @return
     */
    public Role selectRoleById(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    /**
     * 角色信息分页显示
     *
     * @param role 角色实体
     * @return
     */
    public String selectRoleResultPageList(Role role) {

        List<Role> roleList = roleMapper.selectRoleListByPage(role);
        Long count = roleMapper.selectCountRole(role);
        role.setTotalCount(count);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("totalSize", role.getTotalSize());
        map.put("rows", roleList);

        return Json.toJson(map);
    }


    /**
     * 保存角色信息
     *
     * @param role      角色对象
     * @param loginName 当前登录用户
     * @return
     * @throws Exception
     */
    @Transactional
    public ResultInfo saveOrUpdateRole(Role role, String loginName) throws Exception {
        log.info("保存用户角色开始");
        long start = System.currentTimeMillis();
        try {
            //保存角色信息
            if (null == role.getRoleId()) {
                role.setCreator(loginName);
                role.setCreateTime(new Date());
                roleMapper.insertSelective(role);
            } else {
                //更新角色
                role.setModifier(loginName);
                role.setModifierTime(new Date());
                roleMapper.updateByPrimaryKeySelective(role);
            }
        } catch (Exception e) {
            log.error("保存角色方法内部错误", e);
            throw e;
        } finally {
            log.info("保存角色信息结束,用时" + (System.currentTimeMillis() - start) + "毫秒");
        }
        return ResultInfo.returnCodeMessage(ResultCode.GLOBAL_SUCCESS);
    }



    /**
     * 查询状态为有效,待分配的角色信息(用以用户分配角色时显示)
     * @param 已分配角色Id,以逗号分割
     */
    public String selectUserRoleByRoleIdList(String roleIds){
        Map<String, Object> map = new HashMap<String, Object>();
        //如果已给用户分配角色,则待分配用户显示栏中去除已分配的角色信息
        if(StringUtils.isNotEmpty(roleIds)){
            Integer[] roleIdInt = ParseObjectUtils.strArrayToIntArray(roleIds);
            List<Role> lists = roleMapper.selectUserRoleByRoleIdList(roleIdInt);
            map.put("rows", lists);
            return Json.toJson(map);
        }
        map.put("rows", roleMapper.selectRoleList());
        //没有给用户分配角色,待分配显示栏中显示所有角色信息
        return Json.toJson(map);
    }
    /**
     * 查询状态为有效,已分配的角色信息(用已用户分配角色显示)
     * @param roleIds 角色Id
     * @return
     */
    public String selectDeceasedUserRoleByRoleIdList(String roleIds){
        Map<String, Object> map = new HashMap<String, Object>();
        //没有给用户分配角色，则已分配角色列表为空
        if(StringUtils.isNotEmpty(roleIds)){
            Integer[] roleIdInt = ParseObjectUtils.strArrayToIntArray(roleIds);
            List<Role> lists = roleMapper.selectDeceasedUserRoleByRoleIdList(roleIdInt);
            map.put("rows", lists);
            return Json.toJson(map);
        }
        return null;
    }
}
