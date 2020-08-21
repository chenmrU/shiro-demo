package com.cmr.shirodemo.shiro;

import com.cmr.shirodemo.entity.User;
import com.cmr.shirodemo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chenmengrui
 * @Description: 自定义 Realm
 * @date 2020/8/21 9:28
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByName(token.getUsername());
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        User dbUser = userService.findById(user.getId());
        simpleAuthorizationInfo.addStringPermission(dbUser.getPerms());
        return simpleAuthorizationInfo;
    }

}
