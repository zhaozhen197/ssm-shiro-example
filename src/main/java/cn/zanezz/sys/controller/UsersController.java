package cn.zanezz.sys.controller;


import cn.zanezz.sys.realm.PasswordHelper;
import cn.zanezz.sys.entity.Users;
import cn.zanezz.sys.service.IUsersService;
import org.apache.logging.log4j.LogManager;
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


    @RequestMapping("/test")
    public void testUserWrapper() {
        List<Users> users = usersService.list();
        System.out.println(users);
    }


    /**
     * 添加登录用户
     * @param users
     */
    @RequestMapping("/addUsers")
    public void addLoginUser(Users users) {
        passwordHelper.encryptPassword(users);
        System.out.println(users.getPassword());
        boolean flag = usersService.save(users);

    }
}
