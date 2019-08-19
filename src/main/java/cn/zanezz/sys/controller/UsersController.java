package cn.zanezz.sys.controller;


import cn.zanezz.sys.realm.PasswordHelper;
import cn.zanezz.sys.entity.Users;
import cn.zanezz.sys.service.IUsersService;
import org.apache.logging.log4j.LogManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaozhen
 * @since 2019-08-16
 */
@RestController
@RequestMapping("/sys/users")
public class UsersController {

    private static Logger logger = LogManager.getLogger(UsersController.class.getName());
    @Autowired
    private IUsersService usersService;
    @Autowired
    private PasswordHelper passwordHelper;


    /**
     * 必须登录才能访问
     */
    @RequestMapping("/test")
    @RequiresPermissions("role:create")
    public void testUserWrapper() {
        List<Users> users = usersService.list();
        System.out.println(users);
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.hasRole("admin")) {
            System.out.println("admin 已登录");
        }

        if (currentUser.isPermitted("role:create")) {
            System.out.println("admin 已授权");
        }

    }


    /**
     * 添加登录用户，必须拥有管理员权限才能操作
     * @param users
     */
    @RequestMapping("/addUsers")
    @RequiresRoles({"admin"})
    public void addLoginUser(Users users) {
        passwordHelper.encryptPassword(users);
        System.out.println(users.getPassword());
        boolean flag = usersService.save(users);
    }
}
