package cn.zanezz.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: helloSSM->FreeMarkerTest
 * @description: freemarker学习测试
 * @author: zhaozhen
 * @create: 2019-08-16 11:20
 **/

@Controller
public class FreeMarkerTest {
    @RequestMapping("/helloFreeMarker")
    public String helloFreeMarker(Model model) {
        model.addAttribute("name","ITDragon博客");
        return "helloFreeMarker";
    }

}
