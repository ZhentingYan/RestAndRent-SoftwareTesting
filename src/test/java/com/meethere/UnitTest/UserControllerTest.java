package com.meethere.UnitTest;

import com.meethere.controller.user.UserController;
import com.meethere.entity.User;
import com.meethere.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void UT_TD_FUN_005_001_001() throws Exception {
        mockMvc.perform(get("/signup")).andExpect(view().name("signup")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_005_002_001() throws Exception {
        User user=new User();
        user.setUserID("1");
        mockMvc.perform(get("/signup").sessionAttr("user",user)).andExpect(view().name("index")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_005_003_001() throws Exception{
        mockMvc.perform(get("/login")).andExpect(view().name("login")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_005_003_002() throws Exception{
        User user=new User();
        user.setUserID("1");
        User admin=new User();
        admin.setUserID("2");
        mockMvc.perform(get("/login").sessionAttr("user",user).sessionAttr("admin",admin)).andExpect(view().name("login")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_005_004_001() throws Exception{
        User admin=new User();
        admin.setUserID("2");
        mockMvc.perform(get("/login").sessionAttr("admin",admin)).andExpect(view().name("admin/admin_index")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_005_005_001() throws Exception{
        User user=new User();
        user.setUserID("1");
        mockMvc.perform(get("/login").sessionAttr("user",user)).andExpect(view().name("index")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_005_006_001() throws Exception{
        when(userService.checkLogin(anyString(),anyString())).thenReturn(null);
        ResultActions perform=mockMvc.perform(post("/loginCheck.do").param("userID","user").param("password","password"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }

    @Test
    public void UT_TD_FUN_005_006_002() throws Exception{
        when(userService.checkLogin(anyString(),anyString())).thenReturn(null);
        ResultActions perform=mockMvc.perform(post("/loginCheck.do").param("userID","user").param("password","password"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }

    @Test
    public void UT_TD_FUN_005_007_001() throws Exception{
        User user=new User();
        user.setUserID("user");
        user.setPassword("password");
        user.setIsadmin(0);
        when(userService.checkLogin(anyString(),anyString())).thenReturn(user);
        ResultActions perform=mockMvc.perform(post("/loginCheck.do").param("userID","user").param("password","password"));
        perform.andExpect(content().string("/index")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_005_008_001() throws Exception{
        User user=new User();
        user.setUserID("admin");
        user.setPassword("admin");
        user.setIsadmin(1);
        when(userService.checkLogin(anyString(),anyString())).thenReturn(user);
        ResultActions perform=mockMvc.perform(post("/loginCheck.do").param("userID","admin").param("password","admin"));
        perform.andExpect(content().string("/admin_index")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_005_009_001() throws Exception{
        User user=new User();
        user.setUserID("admin");
        user.setPassword("admin");
        user.setIsadmin(2);
        when(userService.checkLogin(anyString(),anyString())).thenReturn(user);
        ResultActions perform=mockMvc.perform(post("/loginCheck.do").param("userID","admin").param("password","admin"));
        perform.andExpect(content().string("false")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_005_010_001()throws Exception {

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/register.do").param("userID","user").param("userName","name").param("password","password")
                                .param("email","email").param("phone","18916272793")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_005_011_001()throws Exception {

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/register.do").param("userID","user").param("userName","name").param("password","password")
                                .param("email","1651200@qq.com").param("phone","1891627279")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_005_012_001()throws Exception {

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/register.do").param("userID","").param("userName","name").param("password","password")
                                .param("email","1651200@qq.com").param("phone","18916272793")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_005_013_001()throws Exception {

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/register.do").param("userID","user").param("userName","name").param("password","")
                                .param("email","1651200@qq.com").param("phone","18916272793")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_005_014_001()throws Exception {

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/register.do").param("userID","user").param("userName","").param("password","password")
                                .param("email","1651200@qq.com").param("phone","18916272793")));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_005_015_001()throws Exception {

        ResultActions perform=mockMvc.perform(post("/register.do").param("userID","user").param("userName","name").param("password","password")
                .param("email","1651200@qq.com").param("phone","18916272793"));
        perform.andExpect(redirectedUrl("login"));
        verify(userService).create(any());
    }

    @Test
    public void UT_TD_FUN_005_016_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxx.jpg",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","user").param("userName","name")
                        .param("passwordNew", "password")
                        .param("email","email").param("phone","18916272793");

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(builder));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_005_017_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxx.jpg",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","user").param("userName","name")
                        .param("passwordNew", "password")
                        .param("email","1651200@qq.com").param("phone","1891627279");

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(builder));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_005_018_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxx.jpg",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","").param("userName","name")
                        .param("passwordNew", "password")
                        .param("email","1651200@qq.com").param("phone","18916272793");

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(builder));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }

    @Test
    public void UT_TD_FUN_005_019_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxx.jpg",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","user").param("userName","")
                        .param("passwordNew", "password")
                        .param("email","1651200@qq.com").param("phone","18916272793");

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(builder));
        assertTrue(thrown.getMessage().contains("用户参数不符合规范！"));
    }



    @Test
    public void UT_TD_FUN_005_020_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","user").param("userName","name")
                        .param("passwordNew", (String) null)
                        .param("email","1651200@qq.com").param("phone","18916272793");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));
        verify(userService).findByUserID(anyString());
        verify(userService).updateUser(any());
    }

    @Test
    public void UT_TD_FUN_005_021_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxx.jpg",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","user").param("userName","name")
                        .param("passwordNew", (String) null)
                        .param("email","1651200@qq.com").param("phone","18916272793");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));
        verify(userService).findByUserID(anyString());
        verify(userService).updateUser(any());
    }

    @Test
    public void UT_TD_FUN_005_022_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","user").param("userName","name")
                        .param("passwordNew", "")
                        .param("email","1651200@qq.com").param("phone","18916272793");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));
        verify(userService).findByUserID(anyString());
        verify(userService).updateUser(any());
    }

    @Test
    public void UT_TD_FUN_005_023_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxx.jpg",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","user").param("userName","name")
                        .param("passwordNew", "")
                        .param("email","1651200@qq.com").param("phone","18916272793");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));
        verify(userService).findByUserID(anyString());
        verify(userService).updateUser(any());
    }

    @Test
    public void UT_TD_FUN_005_024_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","user").param("userName","name")
                        .param("passwordNew", "newPassword")
                        .param("email","1651200@qq.com").param("phone","18916272793");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));
        verify(userService).findByUserID(anyString());
        verify(userService).updateUser(any());
    }

    @Test
    public void UT_TD_FUN_005_025_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxx.jpg",
                "picture", "".getBytes());
        when(userService.findByUserID(anyString())).thenReturn(new User());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","user").param("userName","name")
                        .param("passwordNew", "newPassword")
                        .param("email","1651200@qq.com").param("phone","18916272793");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));
        verify(userService).findByUserID(anyString());
        verify(userService).updateUser(any());
    }

    @Test
    public void UT_TD_FUN_005_026_001()throws Exception {

        when(userService.findByUserID("user")).thenReturn(null);
        ResultActions perform=mockMvc.perform(get("/checkPassword.do").param("userID","user").param("password","password"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }

    @Test
    public void UT_TD_FUN_005_027_001()throws Exception {
        User user=new User();
        user.setUserID("user");
        user.setPassword("password");
        when(userService.findByUserID("user")).thenReturn(user);
        ResultActions perform=mockMvc.perform(get("/checkPassword.do").param("userID","user").param("password","password"));
        perform.andExpect(status().isOk()).andExpect(content().string("true"));
    }

    @Test
    public void UT_TD_FUN_005_027_002()throws Exception {
        User user=new User();
        user.setUserID("user");
        user.setPassword("password1");
        when(userService.findByUserID("user")).thenReturn(user);
        ResultActions perform=mockMvc.perform(get("/checkPassword.do").param("userID","user").param("password","password"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }

    @Test
    public void UT_TD_FUN_005_028_001() throws Exception{
        mockMvc.perform(get("/user_info")).andExpect(status().isOk()).andExpect(view().name("login"));
    }

    @Test
    public void UT_TD_FUN_005_029_001() throws Exception{
        mockMvc.perform(get("/user_info").sessionAttr("user",new User())).andExpect(status().isOk()).andExpect(view().name("user_info"));
    }

    @Test
    public void UT_TD_FUN_005_030_001()throws Exception {
        ResultActions perform=mockMvc.perform(get("/logout.do"));
        perform.andExpect(redirectedUrl("/index"));
    }
    @Test
    public void UT_TD_FUN_005_031_001()throws Exception {
        ResultActions perform=mockMvc.perform(get("/quit.do"));
        perform.andExpect(redirectedUrl("/index"));
    }

}


