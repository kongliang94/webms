/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2017 © yangxiaobing, 873559947@qq.com
 *
 * This file is part of contentManagerSystem.
 * contentManagerSystem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * contentManagerSystem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with contentManagerSystem.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 这个文件是contentManagerSystem的一部分。
 * 您可以单独使用或分发这个文件，但请不要移除这个头部声明信息.
 * contentManagerSystem是一个自由软件，您可以自由分发、修改其中的源代码或者重新发布它，
 * 新的任何修改后的重新发布版必须同样在遵守GPL3或更后续的版本协议下发布.
 * 关于GPL协议的细则请参考COPYING文件，
 * 您可以在contentManagerSystem的相关目录中获得GPL协议的副本，
 * 如果没有找到，请连接到 http://www.gnu.org/licenses/ 查看。
 *
 * - Author: yangxiaobing
 * - Contact: 873559947@qq.com
 * - License: GNU Lesser General Public License (GPL)
 * - source code availability: http://git.oschina.net/yangxiaobing_175/contentManagerSystem
 */
package com.kongl.cms.domain.vo;




import java.io.Serializable;
import java.util.Date;

import com.kongl.cms.domain.dto.PageDto;
import com.kongl.cms.utils.DateUtil;

/**
 * 用户信息实体
 *
 * @author yangxiaobing
 * @date 2017/7/10
 */
public class User extends PageDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_id
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_login_name
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String userLoginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_name
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_password
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_status
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private Long userStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.creator
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.create_time
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.modifier
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String modifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.update_time
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private Date updateTime;


    /**
     * 用户所对应的角色id
     */
    private String roleIds;
    /**
     * 用户所对应的角色名称
     */
    private String roleNames;

    private String beginTime;
    private String endTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_user.user_id
     *
     * @return the value of cc_user.user_id
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_user.user_id
     *
     * @param userId the value for cc_user.user_id
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_user.user_login_name
     *
     * @return the value of cc_user.user_login_name
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public String getUserLoginName() {
        return userLoginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_user.user_login_name
     *
     * @param userLoginName the value for cc_user.user_login_name
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName == null ? null : userLoginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_user.user_name
     *
     * @return the value of cc_user.user_name
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_user.user_name
     *
     * @param userName the value for cc_user.user_name
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_user.user_password
     *
     * @return the value of cc_user.user_password
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_user.user_password
     *
     * @param userPassword the value for cc_user.user_password
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_user.user_status
     *
     * @return the value of cc_user.user_status
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public Long getUserStatus() {
        return userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_user.user_status
     *
     * @param userStatus the value for cc_user.user_status
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public void setUserStatus(Long userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_user.creator
     *
     * @return the value of cc_user.creator
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_user.creator
     *
     * @param creator the value for cc_user.creator
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_user.create_time
     *
     * @return the value of cc_user.create_time
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_user.create_time
     *
     * @param createTime the value for cc_user.create_time
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_user.modifier
     *
     * @return the value of cc_user.modifier
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_user.modifier
     *
     * @param modifier the value for cc_user.modifier
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_user.update_time
     *
     * @return the value of cc_user.update_time
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_user.update_time
     *
     * @param updateTime the value for cc_user.update_time
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }


    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    /**
     * 创建日期格式化
     * @return
     */
    public String getCreateTime_Lable(){
        if(this.getCreateTime() != null){
            return DateUtil.Date2Stirng2Second(createTime);
        }
        return "";
    }
    /**
     * 修改日期格式化
     * @return
     */
    public String getUpdateTime_Lable(){
        if(this.getUpdateTime() != null){
            return DateUtil.Date2Stirng2Second(updateTime);
        }
        return "";
    }
    public String getUserStatus_Lable(){
        if(this.getUserStatus() != null && this.getUserStatus().intValue() == 0){
            return "0-有效";
        }else if(this.getUserStatus() != null && this.getUserStatus().intValue() == 1){
            return "1-失效";
        }else{
            return "";
        }

    }
}