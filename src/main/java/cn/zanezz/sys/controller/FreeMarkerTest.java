package cn.zanezz.sys.controller;

import cn.zanezz.sys.entity.User;
import cn.zanezz.sys.entity.Users;
import cn.zanezz.sys.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @program: helloSSM->FreeMarkerTest
 * @description: freemarker学习测试
 * @author: zhaozhen
 * @create: 2019-08-16 11:20
 **/

@Controller
@RequestMapping("/freeMarker")
public class FreeMarkerTest {

    @Autowired
    private IUsersService usersService;

    @RequestMapping("/helloFreeMarker")
    public String helloFreeMarker(Model model) {
        model.addAttribute("name","ITDragon博客");
        List<Users> users = usersService.list();
        model.addAttribute("users", users);
        return "helloFreeMarker";
    }

}
