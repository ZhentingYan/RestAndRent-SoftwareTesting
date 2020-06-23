package com.meethere.IntegrationTest.Controller.User;

import com.meethere.MeetHereApplication;
import com.meethere.entity.Order;
import com.meethere.entity.User;
import com.meethere.entity.Venue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@AutoConfigureMockMvc
@Transactional
public class UserOrderApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void IT_TD_015_001_002_001() {
        assertThrows(NestedServletException.class,()->mockMvc.perform(get("/order_manage")),"请登录！");
    }
    @Test
    public void IT_TD_015_001_001_001() throws Exception {
        int id=1;
        String userID="test";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        ResultActions perform=mockMvc.perform(get("/order_manage").sessionAttr("user",user));
        ModelAndView mv=perform.andReturn().getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"total");
    }
    @Test
    public void IT_TD_015_001_001_002() throws Exception {
        int id=1;
        String userID="wrong";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        ResultActions perform=mockMvc.perform(get("/order_manage").sessionAttr("user",user));
        ModelAndView mv=perform.andReturn().getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"total");
    }

    @Test
    public void IT_TD_015_002_001_001()throws Exception {
        ResultActions perform=mockMvc.perform(get("/order_place.do").param("venueID","29"));
        ModelAndView mv=perform.andReturn().getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"venue");
    }
    @Test
    public void IT_TD_015_002_001_002()throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(get("/order_place.do").param("venueID","250")),"venueID不存在！");
    }
    @Test
    public void IT_TD_015_003_001_001()throws Exception {
        mockMvc.perform(get("/order_place")).andExpect(status().isOk());
    }

    @Test
    public void IT_TD_015_005_002_001()throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(post("/addOrder.do").param("venueName","venue")
                        .param("date","").param("startTime","2019-12-22 11:00").param("hours","1")),
                "请登录！");
    }
    @Test
    public void IT_TD_015_005_001_001() throws Exception{
        User user=new User();
        user.setUserID("user");
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                        .param("venueName","wrongname").param("date","").param("startTime","2020-09-20 11:00")
                        .param("hours","5")));
    }
    @Test
    public void IT_TD_015_005_001_002() throws Exception{
        User user=new User();
        user.setUserID("user");
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                        .param("venueName","上海市普陀区图书馆青少年活动室").param("date","").param("startTime","2020-01-05 20:00")
                        .param("hours","5")));
    }
    @Test
    public void IT_TD_015_005_001_003() throws Exception{
        User user=new User();
        user.setUserID("user");
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                .param("venueName","上海市普陀区图书馆青少年活动室").param("date","").param("startTime","2020-09-20 11:00")
                .param("hours","5")));
    }
    @Test
    public void IT_TD_015_005_001_004() throws Exception{
        User user=new User();
        user.setUserID("user");
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                        .param("venueName","wrongname").param("date","").param("startTime","2020-01-05 20:00")
                        .param("hours","5")));
    }
    @Test
    public void IT_TD_015_005_001_005() throws Exception{
        User user=new User();
        user.setUserID("test");
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                        .param("venueName","wrongname").param("date","").param("startTime","2020-09-20 11:00")
                        .param("hours","5")));
    }
    @Test
    public void IT_TD_015_005_001_006() throws Exception{
        User user=new User();
        user.setUserID("test");
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                        .param("venueName","上海市普陀区图书馆青少年活动室").param("date","").param("startTime","2020-01-05 20:00")
                        .param("hours","5")));
    }
    @Test
    public void IT_TD_015_005_001_007() throws Exception{
        User user=new User();
        user.setUserID("test");
        ResultActions perform=mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                .param("venueName","上海市普陀区图书馆青少年活动室").param("date","").param("startTime","2020-09-20 11:00")
                .param("hours","5"));
        perform.andExpect(redirectedUrl("order_manage"));
    }
    @Test
    public void IT_TD_015_005_001_008() throws Exception{
        User user=new User();
        user.setUserID("test");
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                        .param("venueName","wrongname").param("date","").param("startTime","2020-01-05 20:00")
                        .param("hours","5")));
    }
    @Test
    public void IT_TD_015_006_001_001() throws Exception{
        ResultActions perform=mockMvc.perform(post("/finishOrder.do").param("orderID","32"));
        perform.andExpect(status().isOk());
    }
    @Test
    public void IT_TD_015_006_001_002() throws Exception{

        assertThrows(NestedServletException.class,()->mockMvc.perform(post("/finishOrder.do").param("orderID","250")));
    }
    @Test
    public void IT_TD_015_010_001_001() throws Exception{
        ResultActions perform=mockMvc.perform(get("/modifyOrder.do").param("orderID","32"));
        ModelAndView mv=perform.andReturn().getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"venue");
        assertModelAttributeAvailable(mv,"order");
    }
    @Test
    public void IT_TD_015_010_001_002() throws Exception{
        ResultActions perform=mockMvc.perform(get("/modifyOrder.do").param("orderID","250"));
        perform.andExpect(status().isOk()).andExpect(view().name("/index"));
    }


    @Test
    public void IT_TD_015_008_001_001()throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(post("/delOrder.do").param("orderID","250")));
    }
    @Test
    public void IT_TD_015_008_001_002() throws Exception{
        mockMvc.perform(post("/delOrder.do").param("orderID","32")).andExpect(status().isOk()).andExpect(content().string("true"));
    }

    @Test
    public void IT_TD_015_009_001_001()throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(get("/order/getOrderList.do").param("venueName","wrongName").param("date","2019-12-22"))
                .andExpect(status().isOk()));
    }
    @Test
    public void IT_TD_015_009_001_002()throws Exception {
        mockMvc.perform(get("/order/getOrderList.do").param("venueName","上海市普陀区图书馆青少年活动室").param("date","2019-12-22"))
                .andExpect(status().isOk());
    }
}
