package com.meethere.controller.user;

import com.meethere.entity.User;
import com.meethere.service.UserService;
import com.meethere.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;

@Controller
public class UserController {
    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signUp(HttpServletRequest request){
        Object user=request.getSession().getAttribute("user");
        if(user==null)
            return "signup";
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        Object user=request.getSession().getAttribute("user");
        Object admin=request.getSession().getAttribute("admin");
        if(user==null && admin!=null)
            return "admin/admin_index";
        else if(admin==null && user!=null)
            return "index";
        else return "login";
    }

    @PostMapping("/loginCheck.do")
    @ResponseBody
    public String login(String userID,String password, HttpServletRequest request) throws IOException {
        User user=userService.checkLogin(userID,password);
        if(user!=null){
            if(user.getIsadmin()==0){
                request.getSession().setAttribute("user",user);
                System.out.println("user login!");
                return "/index";
            }
            else if(user.getIsadmin()==1){
                request.getSession().setAttribute("admin",user);
                System.out.println("admin login!");
                return "/admin_index";
            }
        }
        return "false";
    }

    @PostMapping("/register.do")
    public void register(String userID,String userName, String password, String email, String phone,
                         HttpServletResponse response) throws IOException{
        if(!(Pattern.matches(REGEX_EMAIL,email) && Pattern.matches(REGEX_MOBILE,phone) && userID!="" && password!="" && userName!=""))
            throw new RuntimeException("用户参数不符合规范！");
        User user=new User();
        user.setUserID(userID);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPicture("");
        userService.create(user);
        response.sendRedirect("login");
    }

    @GetMapping("/logout.do")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        System.out.println("log out success!");
        response.sendRedirect("/index");
    }
    @GetMapping("/quit.do")
    public void quit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("admin");
        System.out.println("log out success!");
        response.sendRedirect("/index");
    }



    @PostMapping("/updateUser.do")
    public void updateUser(String userName, String userID, String passwordNew,String email, String phone, MultipartFile picture,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(!(Pattern.matches(REGEX_EMAIL,email) && Pattern.matches(REGEX_MOBILE,phone) && userID!="" && userName!=""))
            throw new RuntimeException("用户参数不符合规范！");
        User user=userService.findByUserID(userID);
        user.setUserName(userName);
        if(passwordNew!=null&& !"".equals(passwordNew)){
            user.setPassword(passwordNew);
        }
        user.setEmail(email);
        user.setPhone(phone);
        if(!Objects.equals(picture.getOriginalFilename(), "")){
            user.setPicture(FileUtil.saveUserFile(picture));
        }

        userService.updateUser(user);
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user",user);
        response.sendRedirect("user_info");
    }


    @GetMapping("/checkPassword.do")
    @ResponseBody
    public boolean checkPassword(String userID,String password)
    {
        User user=userService.findByUserID(userID);
        if(user!=null)
        return user.getPassword().equals(password);
        else return false;
    }

    @GetMapping("/user_info")
    public String user_info(Model model,HttpServletRequest request){
        Object user=request.getSession().getAttribute("user");
        if(user==null)
            return "login";
        return "user_info";
    }
}
