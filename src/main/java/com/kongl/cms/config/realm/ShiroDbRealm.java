package com.kongl.cms.config.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.kongl.cms.common.constant.SessionConstants;
import com.kongl.cms.domain.vo.Resource;
import com.kongl.cms.domain.vo.User;
import com.kongl.cms.service.ResourceService;
import com.kongl.cms.service.UserService;





public class ShiroDbRealm extends AuthorizingRealm{

	private Log log = LogFactory.getLog(ShiroDbRealm.class);
	@Autowired
    private UserService userService;
    @Autowired
    private ResourceService resourceService;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
            throw new AuthorizationException("Principal对象不能为空");
        }
		User user=(User) getAvailablePrincipal(principals);
		if (user==null) {
			throw new UnknownAccountException();
		}
		String roleNames=user.getRoleNames();
		String roleids=user.getRoleIds();
		Set<String> permissionSet = new HashSet<>();
	    Set<String> roleNameSet = new HashSet<>();

	    for (String id : roleids.split(",")) {
			//通过roleid去查询对应的resource
		}
	    for (String roleName : roleNames.split(",")) {
			roleNameSet.add(roleName);
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();		
		simpleAuthorizationInfo.addRoles(roleNameSet);
		//这里应该是该用户的角色所拥有的权限，下面是直接写死的数据
		Resource res = resourceService.selectByPrimaryKey(2);
		simpleAuthorizationInfo.addStringPermission(res.getResModelCode());
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken userToken = (UsernamePasswordToken) token;
		String username = userToken.getUsername();
        if (StringUtils.isEmpty(username)) {
            log.error("获取认证信息失败，原因:用户名为空");
            throw new AccountException("用户名为空");
        }
        // 根据登陆用户名查询用户信息
        User user = userService.selectUserByloginName(username);
        if (user == null) {
            throw new AccountException("用户信息为空");
        }
        initSession(user);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPassword(), getName());
        if (null != info) {
            log.info("用户认证通过:登陆用户名:" + user.getUserLoginName());
            return info;
        }
		return null;
	}

	 /**
     * 设置用户session
     */
    private void initSession(User user) {
        log.info("sessionTimeOut:" + SessionConstants.sessionTimeOut);
        Session session = SecurityUtils.getSubject().getSession();
        session.setTimeout(SessionConstants.sessionTimeOut);
        session.setAttribute(SessionConstants.SESSION_USER_KEY, user);
    }

}
