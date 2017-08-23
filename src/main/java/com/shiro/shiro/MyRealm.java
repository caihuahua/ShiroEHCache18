package com.shiro.shiro;

/**
 * The Class
 *
 * @author Lanling
 * on 2017/7/24
 */

import com.shiro.permission.dao.PermissionDao;
import com.shiro.permission.dao.RoleDao;
import com.shiro.permission.vo.Role;
import com.shiro.user.dao.UserDao;
import com.shiro.user.vo.User;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao authDao;

    @Autowired
    private RoleDao roleDao;


    /**
     * (non-Javadoc)
     *
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     * 为当前登录的Subject授予角色和权限
     * 本例中该方法的调用时机为需授权资源被访问时
     * 并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String loginName = (String) super.getAvailablePrincipal(principals);
        System.out.println("权限认证!");
        User user= null;
        try {
            user = userDao.findUserByEmail(loginName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null){
            // 权限信息对象info，用来存放查出的用户的所有的角色及权限
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.setRoles(roleDao.getRolesName(user.getId()));
            List<Role> roleList = roleDao.getRoleList(user.getId());
            for (Role role : roleList){
                //用户的角色对应的所有权限
                logger.info("角色: "+role.getName());
                info.addStringPermissions(permissionService.getPermissionsName(role.getId()));
            }
            return info;
        }
        // 返回null将会导致用户访问任何被拦截的请求时都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }


    /**
     * (non-Javadoc)
     *
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     * 验证当前登录的Subject
     * 本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authToken) throws AuthenticationException {

        String username=(String)authToken.getPrincipal();

        System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(username, ToStringStyle.MULTI_LINE_STYLE));

        User user = null;

        try {
            user=userDao.login(new User(username));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user != null) {
            AuthenticationInfo info = new SimpleAuthenticationInfo(user.getEmail(), user.getPswd(), getName());
            //将当前用户设置到Session中去以便获取当前用户信息
            this.setSession("loginUser", user);

            return info;
        }

        return null;
    }


    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     *
     * @see
     */

    private void setSession(Object key, Object value) {
        Subject currSubject = SecurityUtils.getSubject();
        if (currSubject != null) {
            Session session = currSubject.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");

            if (session != null) {
                session.setAttribute(key, value);
            }
        }

    }
}

