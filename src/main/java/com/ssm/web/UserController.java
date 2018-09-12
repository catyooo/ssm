package com.ssm.web;

import com.ssm.entity.User;
import com.ssm.service.IUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    //静态日之类loggerMaggent
    private static final Logger logger = LogManager.getLogger(UserController.class.getName());


    @RequestMapping(value = "regSubmit", method = RequestMethod.POST)
    public String regSubmit(@RequestParam("loginName") String loginName,
                            @RequestParam("password") String password,
                            @RequestParam("userName") String userName) {
        logger.info("regSubmit POST 方法被调用……");
        //创建user对象
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setUserName(userName);
        //模拟数据库存储User信息
        iUserService.insertSelective(user);
        return "jsp/reg-result";
    }


    @RequestMapping(value = "showname", method = RequestMethod.GET)
    public String showUserName(@RequestParam("uid") String uid, HttpServletRequest request, Model model) {
        User user = iUserService.getUserById(uid);
        if (user != null) {
            request.setAttribute("name", user.getUserName());
            model.addAttribute("mame", user.getUserName());
            return "/jsp/showName";
        }
        request.setAttribute("error", "没有找到该用户！");
        return "/jsp/error";
    }


    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerForm() {
        logger.info("register GET 方法被调用……");
        return "/jsp/registerForm";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@RequestParam("loginname") String loginname,
                           @RequestParam("password") String password,
                           @RequestParam("username") String username) {
        logger.info("register POST 方法被调用……");
        //创建user对象
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setLoginName(loginname);
        user.setPassword(password);
        user.setUserName(username);
        //模拟数据库存储User信息
        iUserService.insertSelective(user);
        return "loginForm";
    }

    //登录
    @RequestMapping("login")
    public String login(HttpServletRequest request,
                        @RequestParam("loginname") String loginname,
                        @RequestParam("password") String password, Model model) {
        logger.info("登录名：" + loginname + " 密码：" + password);
        //到集合中查找用户是否存在，此处用来模拟数据库验证

        User user = new User();
        user.setLoginName(loginname);
        user.setPassword(password);

        User userInfo = iUserService.checkUserInfo(user);

        if (null != userInfo) {
            model.addAttribute("userInfo", userInfo);
            return "/jsp/welcome";
        } else {
            request.setAttribute("error", "用户名或者密码错误！");
            return "/jsp/error";
        }
    }

}
