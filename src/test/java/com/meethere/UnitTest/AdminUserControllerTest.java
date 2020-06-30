package com.meethere.UnitTest;

import com.meethere.controller.admin.AdminUserController;
import com.meethere.entity.User;
import com.meethere.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminUserController.class)
class AdminUserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void UT_TD_FUN_002_001_001() throws Exception {
        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        when(userService.findById(anyInt())).thenReturn(user);

        ResultActions perform=mockMvc.perform(get("/user_edit").param("id","1"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"user");
        verify(userService).findById(anyInt());

    }

    @Test
    public void UT_TD_FUN_002_002_001() throws Exception {

        when(userService.findById(anyInt())).thenReturn(null);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(get("/user_edit").param("id","1")));
        assertTrue(thrown.getMessage().contains("用户ID不存在！"));
    }

    @Test
    public void UT_TD_FUN_002_003_001() throws Exception {

        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        when(userService.findByUserID(anyString())).thenReturn(user);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyUser.do").param("userID","user123").param("oldUserID","user").param("userName","userName").param("password","password")
                                .param("email","email").param("phone","18916272793")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_002_004_001() throws Exception {

        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        when(userService.findByUserID(anyString())).thenReturn(user);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyUser.do").param("userID","user123").param("oldUserID","user").param("userName","userName").param("password","password")
                                .param("email","1651200@163.com").param("phone","1891627279")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_002_005_001() throws Exception {

        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        when(userService.findByUserID(anyString())).thenReturn(user);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyUser.do").param("userID","").param("oldUserID","user").param("userName","userName").param("password","password")
                                .param("email","1651200@163.com").param("phone","18916272793")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_002_006_001() throws Exception {

        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        when(userService.findByUserID(anyString())).thenReturn(user);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyUser.do").param("userID","user123").param("oldUserID","user").param("userName","userName").param("password","")
                                .param("email","1651200@163.com").param("phone","18916272793")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_002_007_001() throws Exception {

        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        when(userService.findByUserID(anyString())).thenReturn(user);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyUser.do").param("userID","user123").param("oldUserID","user").param("userName","").param("password","password")
                                .param("email","1651200@163.com").param("phone","18916272793")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_002_008_001() throws Exception {

        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        when(userService.findByUserID(anyString())).thenReturn(user);

        ResultActions perform=mockMvc.perform(post("/modifyUser.do").param("userID","user123").param("oldUserID","user").param("userName","userName").param("password","password")
                .param("email","1651200@163.com").param("phone","18916272793"));
        perform.andExpect(redirectedUrl("user_manage"));
        verify(userService).findByUserID(anyString());
        verify(userService).updateUser(any());
    }

    @Test
    public void UT_TD_FUN_002_009_001() throws Exception {

        String userID="1";
        String userName="username";
        String password="password";
        String email="222qq.com";
        String phone="18916272793";

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addUser.do").param("userID",userID).param("userName",userName).param("password",password)
                                .param("email",email).param("phone",phone)));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }
    @Test
    public void UT_TD_FUN_002_010_001() throws Exception {

        String userID="1";
        String userName="username";
        String password="password";
        String email="1651200@qq.com";
        String phone="1891627279";

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addUser.do").param("userID",userID).param("userName",userName).param("password",password)
                                .param("email",email).param("phone",phone)));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_002_011_001() throws Exception {

        String userID="";
        String userName="username";
        String password="password";
        String email="1651200@qq.com";
        String phone="18916272793";

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addUser.do").param("userID",userID).param("userName",userName).param("password",password)
                                .param("email",email).param("phone",phone)));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }
    @Test
    public void UT_TD_FUN_002_012_001() throws Exception {

        String userID="1";
        String userName="username";
        String password="";
        String email="1651200@qq.com";
        String phone="18916272793";

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addUser.do").param("userID",userID).param("userName",userName).param("password",password)
                                .param("email",email).param("phone",phone)));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }
    @Test
    public void UT_TD_FUN_002_013_001() throws Exception {

        String userID="1";
        String userName="";
        String password="password";
        String email="1651200@qq.com";
        String phone="18916272793";

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addUser.do").param("userID",userID).param("userName",userName).param("password",password)
                                .param("email",email).param("phone",phone)));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_002_014_001() throws Exception {

        String userID="1";
        String userName="username";
        String password="password";
        String email="1651200@qq.com";
        String phone="18916272793";

        ResultActions perform=mockMvc.perform(post("/addUser.do").param("userID",userID).param("userName",userName).param("password",password)
                .param("email",email).param("phone",phone));
        perform.andExpect(redirectedUrl("user_manage"));
        verify(userService).create(any());
    }

    @Test
    public void UT_TD_FUN_002_015_001() throws Exception {
        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        List<User> users=new ArrayList<>();
        users.add(user);
        Pageable user_pageable= PageRequest.of(0,10, Sort.by("id").ascending());
        when(userService.findByUserID(user_pageable)).thenReturn(new PageImpl<>(users,user_pageable,1));

        ResultActions perform=mockMvc.perform(get("/user_manage"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"total");
        verify(userService).findByUserID(user_pageable);
    }

    @Test
    public void UT_TD_FUN_002_016_001() throws Exception {
        ResultActions perform=mockMvc.perform(get("/user_add"));
        perform.andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_002_017_001() throws Exception {
        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        List<User> users=new ArrayList<>();
        users.add(user);
        Pageable user_pageable= PageRequest.of(0,10, Sort.by("id").ascending());
        when(userService.findByUserID(user_pageable)).thenReturn(new PageImpl<>(users,user_pageable,1));

        ResultActions perform=mockMvc.perform(get("/userList.do").param("page","1"));
        perform.andExpect(status().isOk());
        verify(userService).findByUserID(user_pageable);
    }

    @Test
    public void UT_TD_FUN_002_018_001() throws Exception {
        when(userService.countUserID("user")).thenReturn(0);
        ResultActions perform=mockMvc.perform(post("/checkUserID.do").param("userID","user"));
        perform.andExpect(status().isOk()).andExpect(content().string("true"));
        verify(userService).countUserID("user");
    }

    @Test
    public void UT_TD_FUN_002_019_001() throws Exception {
        when(userService.countUserID("user")).thenReturn(1);
        ResultActions perform=mockMvc.perform(post("/checkUserID.do").param("userID","user"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
        verify(userService).countUserID("user");
    }

    @Test
    public void UT_TD_FUN_002_020_001() throws Exception {
        ResultActions perform=mockMvc.perform(post("/delUser.do").param("id","1"));
        perform.andExpect(status().isOk());
        verify(userService).delByID(anyInt());
    }
}