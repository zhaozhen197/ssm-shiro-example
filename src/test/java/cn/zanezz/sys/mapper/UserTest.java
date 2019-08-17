package cn.zanezz.sys.mapper;


import cn.zanezz.sys.service.MessageService;
import cn.zanezz.sys.service.MortgageHouseService;
import cn.zanezz.sys.service.UserService;
import cn.zanezz.sys.entity.MortgageHouse;
import cn.zanezz.sys.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml", "classpath:spring/spring-service.xml", "classpath:spring/spring-shiro.xml"})
public class UserTest {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @Autowired
    private MortgageHouseService mortgageHouseService;

    @Test
    public void testUserInser() {
        User user = new User();
        user.setName1("赵先生");
        user.setPhone("15090109700");
        userService.insertUser(user);
    }

    @Test
    public void testMortageHouse() {
        List<MortgageHouse> mortgageHouselist = mortgageHouseService.selectAllMortgageHouse();
        System.out.println(mortgageHouselist);
    }
}
