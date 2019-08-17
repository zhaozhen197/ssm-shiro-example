package cn.zanezz.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.zanezz.sys.controller.UsersController;
import cn.zanezz.sys.entity.Users;
import cn.zanezz.sys.realm.PasswordHelper;
import cn.zanezz.sys.service.IUsersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @program: helloSSM->WrapperTest
 * @description: wrapperTest
 * @author: zhaozhen
 * @create: 2019-08-16 19:14
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml", "classpath:spring/spring-service.xml", "classpath:spring/spring-shiro.xml"})
public class WrapperTest  {

    private static Logger logger = LogManager.getLogger(UsersController.class.getName());

    @Autowired
    private IUsersService usersService;

    @Autowired
    private PasswordHelper passwordHelper;
    @Test
    public void testWrapper() {
        List<Users> userlist = usersService.list(new QueryWrapper<Users>().eq("username", "admin"));

        System.out.println("111111111111111111111111111111111"+userlist);
        logger.error(userlist);
        logger.info(userlist);

    }

    /**
     * 测试添加用户
     */
    @Test
    public void addUsers() {
        Users auser = new Users();
        auser.setUsername("zhaozhen");
        auser.setPassword("zhaozhen");
        auser.setLocked(false);

        passwordHelper.encryptPassword(auser);
        System.out.println(auser.getPassword());

        usersService.save(auser);
    }

}
