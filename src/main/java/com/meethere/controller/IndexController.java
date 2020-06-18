package com.meethere.controller;

import com.meethere.entity.*;
import com.meethere.entity.vo.MessageVo;
import com.meethere.exception.LoginException;
import com.meethere.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private VenueService venueService;
    @Autowired
    private MessageVoService messageVoService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/index")
    public String index(Model model){
        Pageable venue_pageable= PageRequest.of(0,5, Sort.by("venueID").ascending());
        Pageable news_pageable= PageRequest.of(0,5, Sort.by("time").descending());
        Pageable message_pageable= PageRequest.of(0,5, Sort.by("time").descending());

        List<Venue> venue_list=venueService.findAll(venue_pageable).getContent();
        List<News> news_list= newsService.findAll(news_pageable).getContent();
        Page<Message> messages=messageService.findPassState(message_pageable);
        List<MessageVo> message_list=messageVoService.returnVo(messages.getContent());
        List<Venue> venue_list_for_display=venueService.findAll();
        List<User> user_list= userService.findAll();
        List<Order> order_list=orderService.findAll();
        model.addAttribute("user", null);
        model.addAttribute("user", null);
        model.addAttribute("news_list",news_list);
        model.addAttribute("venue_list",venue_list);
        model.addAttribute("message_list",message_list);
        model.addAttribute("venue_num",venue_list_for_display.size());
        model.addAttribute("user_num",user_list.size());
        model.addAttribute("order_num",order_list.size());
        return "index";
    }


    @GetMapping("/admin_index")
    public String admin_index(Model model,HttpServletRequest request){
        Object admin=request.getSession().getAttribute("admin");
        Object user=request.getSession().getAttribute("user");

        if(user==null && admin==null){
            throw new LoginException("请登录！");
        }else{
            if(user!=null)
                throw new RuntimeException("权限不足，普通用户不可进入后台管理界面！");
            else return "admin/admin_index";
        }
    }



//    @GetMapping("/user_edit")
//    public String user_edit(Model model){
//        return "admin/user_edit";
//    }
}
