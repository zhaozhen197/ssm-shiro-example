package cn.zanezz.sys.realm;

import cn.zanezz.sys.entity.Users;
import cn.zanezz.sys.service.IUsersService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zane
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUsersService usersService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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