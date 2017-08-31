
package com.kongl.cms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kongl.cms.domain.vo.Role;

import java.util.List;


@Mapper
public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_role
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    int deleteByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_role
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_role
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_role
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    Role selectByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_role
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_role
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    int updateByPrimaryKey(Role record);


    /**
     * 查询角色总记录数
     * @param role 角色实体
     * @return
     */
    Long selectCountRole(Role role);

    /**
     * 角色信息分页列表显示
     * @param role 角色实体
     * @return
     */
    List<Role> selectRoleListByPage(Role role);


    /**
     * 根据用户Id查询用户所对应的角色信息
     * @param userId 用户Id
     * @return
     */
    List<Role> selectUserRolesByUserId(@Param("userId") Integer userId);

    /**
     * 查询状态为有效的所有角色信息
     * @return
     */
     List<Role>selectRoleList();

    /**
     *  查询状态为有效的待分配角色信息(已分配的角色信息除外)
     *  @param roleId 角色Id
     */
    List<Role> selectUserRoleByRoleIdList(Integer[] roleId);

    /**
     * 查询状态为有效的已分配角色信息
     * @param roleId 角色Id
     * @return
     */
    List<Role> selectDeceasedUserRoleByRoleIdList(Integer[] roleId);

    /**
     * 
     * <p>function:根据角色名查询角色
     * <p>User: 
     * <p>Date: 
     *
     */
	Role selectRoleByName(String roleName);


}