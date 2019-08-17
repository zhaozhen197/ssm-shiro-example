package cn.zanezz.sys.controller;

import cn.zanezz.sys.entity.Users;
import cn.zanezz.sys.realm.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zane
 */
@Controller
@RequestMapping("/user")

public class LoginController {

    @Autowired
    private PasswordHelper passwordHelper;
    /**
     * 用户登录的入口
     *
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/userLogin")
    public String login(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "remember", required = false) String remember,
            Model model) {
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        users.setLocked(false);

        System.out.println("登陆用户输入的用户名：" + username + "，密码：" + password);
        String error = null;
        if (username != null && password != null) {
            //初始化
            Subject subject = SecurityUtils.getSubject();
            passwordHelper.encryptPassword(users);
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);

            if (remember != null){
                if (remember.equals("on")) {
                    //说明选择了记住我
                    token.setRememberMe(true);
                } else {
                    token.setRememberMe(false);
                }
            }else{
                token.setRememberMe(false);
            }

            try {
                //登录，即身份校验，由通过Spring注入的UserRealm会自动校验输入的用户名和密码在数据库中是否有对应的值
                subject.login(token);
                System.out.println("用户是否登录：" + subject.isAuthenticated());
                return "redirect:index";
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                error = "用户账户不存在，错误信息：" + e.getMessage();
            } catch (IncorrectCredentialsException e) {
                e.printStackTrace();
                error = "用户名或密码错误，错误信息：" + e.getMessage();
            } catch (LockedAccountException e) {
                e.printStackTrace();
                error = "该账号已锁定，错误信息：" + e.getMessage();
            } catch (DisabledAccountException e) {
                e.printStackTrace();
                error = "该账号已禁用，错误信息：" + e.getMessage();
            } catch (ExcessiveAttemptsException e) {
                e.printStackTrace();
                error = "该账号登录失败次数过多，错误信息：" + e.getMessage();
            } catch (Exception e){
                e.printStackTrace();
                error = "未知错误，错误信息：" + e.getMessage();
            }
        } else {
            error = "请输入用户名和密码";
        }
        //登录失败，跳转到login页面
        model.addAttribute("error", error);
        return "login";
    }

//    /**
//     * 退出登录，我们不需要实现，Shiro的Filter过滤器会帮我们生成一个logout请求，
//     *    当浏览器访问`/logout`请求时，Shiro会自动清空缓存并重定向到配置好的loginUrl页面
//     *
//     * @return
//     */
//    @RequestMapping("/logout")
//    public String logout() {
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
//        return "index";
//    }

    /**
     * 登录成功，跳转到首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }
}
