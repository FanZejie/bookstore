package cn.fzj.controller;

import cn.fzj.mapper.UserMapper;
import cn.fzj.pojo.User;
import cn.fzj.service.UserService;
import cn.fzj.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkCode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        /*System.out.println(checkCode_server);
        System.out.println(checkCode);*/
        if (checkCode_server==null||!checkCode_server.equalsIgnoreCase(checkCode)){
            request.setAttribute("msg","验证码输入错误");
            return "login";
        }
        User loginUser = userService.login(email, password);
        if (loginUser==null){
            boolean emailExist = userService.CheckUserExist(email);
            if (emailExist){
                model.addAttribute("msg","密码错误");
            }else {
                model.addAttribute("msg","该邮箱未注册用户");
            }
            return "login";
        }else {
            session.setAttribute("user",loginUser);
            model.addAttribute("user",loginUser);
            model.addAttribute("username",loginUser.getUsername());
            return "index";
        }

    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request,Model model){
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        System.out.println(email);
        HttpSession session = request.getSession();
        String checkCode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if (checkCode_server==null||!checkCode_server.equalsIgnoreCase(checkCode)){
            request.setAttribute("msg","验证码输入错误");
            return "register";
        }
        int flag = userService.register(username, password, email);
        if (flag == 1){
            request.setAttribute("msg","注册成功");
            System.out.println("注册成功");
            return "login";
        }else {
            request.setAttribute("msg","注册失败，暂时无法注册，等待服务器维修");
            return "register";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "login";
    }

}
