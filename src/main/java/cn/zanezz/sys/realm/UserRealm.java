package cn.zanezz.sys.realm;

import cn.zanezz.sys.entity.Permissions;
import cn.zanezz.sys.entity.Roles;
import cn.zanezz.sys.entity.Users;
import cn.zanezz.sys.service.IUsersRolesService;
import cn.zanezz.sys.service.IUsersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author zane
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUsersService usersService;

    @Autowired
    private IUsersRolesService usersRolesService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限校验--执行了doGetAuthorizationInfo...");
        Users users = (Users) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //注意这里的setRoles和setStringPermissions需要的都是一个Set<String>类型参数
        Set<String> role = new HashSet<String>();

        //权限集合
        HashSet<String> roleSet = new HashSet<>();

        List<Roles> rolesList = new ArrayList<>();
        rolesList = usersService.getRolesByUsername(users.getUsername());

        for (Roles r: rolesList) {
            roleSet.add(r.getRole());

        }
        authorizationInfo.setRoles(roleSet);

        /**
         * 添加权限信息
         */
        List<Permissions> permissions = usersService.getPermissionsByUsername(users.getUsername());
        Set<String> permissionSet = new HashSet<>();
        for ( Permissions permission: permissions) {
            permissionSet.add(permission.getPermission());
        }
        authorizationInfo.setStringPermissions(permissionSet);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("====login=====");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = (String) usernamePasswordToken.getPrincipal();
        Users users = usersService.findUserByName(username);
        System.out.println(users);

        if (users == null) {
            throw new UnknownAccountException();
        }

        if (Boolean.TRUE.equals(users.getLocked())) {
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                users,
                users.getPassword(),
                ByteSource.Util.bytes(users.getCredentialsSalt()), //salt=username+salt
                getName()
        );

        return authenticationInfo;

    }

}