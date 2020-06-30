package com.meethere.UnitTest;

import com.meethere.controller.user.OrderController;
import com.meethere.entity.Order;
import com.meethere.entity.User;
import com.meethere.entity.Venue;
import com.meethere.service.OrderService;
import com.meethere.service.OrderVoService;
import com.meethere.service.VenueService;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderService orderService;
    @MockBean
    private OrderVoService orderVoService;
    @MockBean
    private VenueService venueService;


    @Test
    public void UT_TD_FUN_004_001_001() throws Exception {
        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="18916272793";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);

        int orderID=1;
        int venueID=2;
        LocalDateTime order_time=LocalDateTime.now();
        LocalDateTime start_time= LocalDateTime.now().plusDays(1);
        int hours=3;
        int state=1;
        int total=300;

        Pageable order_pageable = PageRequest.of(0,5, Sort.by("orderTime").descending());
        Order order=new Order(orderID,userID,venueID,state,order_time,start_time,hours,total);
        Order order1=new Order(2,userID,venueID,state,order_time,start_time.plusHours(4),hours,total);
        List<Order> orders=new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        when(orderService.findUserOrder(userID,order_pageable)).thenReturn(new PageImpl<>(orders,order_pageable,1));

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(get("/order_manage")));
        assertTrue(thrown.getMessage().contains("请登录！"));
    }

    @Test
    public void UT_TD_FUN_004_002_001() throws Exception {
        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="18916272793";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);

        int orderID=1;
        int venueID=2;
        LocalDateTime order_time=LocalDateTime.now();
        LocalDateTime start_time= LocalDateTime.now().plusDays(1);
        int hours=3;
        int state=1;
        int total=300;

        Pageable order_pageable = PageRequest.of(0,5, Sort.by("orderTime").descending());
        Order order=new Order(orderID,userID,venueID,state,order_time,start_time,hours,total);
        Order order1=new Order(2,userID,venueID,state,order_time,start_time.plusHours(4),hours,total);
        List<Order> orders=new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        when(orderService.findUserOrder(userID,order_pageable)).thenReturn(new PageImpl<>(orders,order_pageable,1));

        ResultActions perform=mockMvc.perform(get("/order_manage").sessionAttr("user",user));
        ModelAndView mv=perform.andReturn().getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"total");
        verify(orderService).findUserOrder(userID,order_pageable);
    }

    @Test
    public void UT_TD_FUN_004_003_001() throws Exception {
        when(venueService.findByVenueID(anyInt())).thenReturn(null);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(get("/order_place.do").param("venueID","1")));
        assertTrue(thrown.getMessage().contains("venueID不存在！"));
    }

    @Test
    public void UT_TD_FUN_004_004_001() throws Exception {
        when(venueService.findByVenueID(anyInt())).thenReturn(new Venue());
        ResultActions perform=mockMvc.perform(get("/order_place.do").param("venueID","1"));
        ModelAndView mv=perform.andReturn().getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"venue");
        verify(venueService).findByVenueID(anyInt());
    }

    @Test
    public void UT_TD_FUN_004_005_001() throws Exception {
        int id=1;
        String userID="user";
        User user=new User();
        user.setUserID("user");

        int orderID=1;
        int venueID=2;
        LocalDateTime order_time=LocalDateTime.now();
        LocalDateTime start_time= LocalDateTime.now().plusDays(1);
        int hours=3;
        int state=1;
        int total=300;

        Pageable order_pageable = PageRequest.of(0,5, Sort.by("orderTime").descending());
        Order order=new Order(orderID,userID,venueID,state,order_time,start_time,hours,total);
        Order order1=new Order(2,userID,venueID,state,order_time,start_time.plusHours(4),hours,total);
        List<Order> orders=new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        when(orderService.findUserOrder(userID,order_pageable)).thenReturn(new PageImpl<>(orders,order_pageable,1));
        when(orderVoService.returnVo(any())).thenReturn(null);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(get("/getOrderList.do").param("page","1")));
        assertTrue(thrown.getMessage().contains("请登录！"));
    }

    @Test
    public void UT_TD_FUN_004_006_001() throws Exception {
        int id=1;
        String userID="user";
        User user=new User();
        user.setUserID("user");

        int orderID=1;
        int venueID=2;
        LocalDateTime order_time=LocalDateTime.now();
        LocalDateTime start_time= LocalDateTime.now().plusDays(1);
        int hours=3;
        int state=1;
        int total=300;

        Pageable order_pageable = PageRequest.of(0,5, Sort.by("orderTime").descending());
        Order order=new Order(orderID,userID,venueID,state,order_time,start_time,hours,total);
        Order order1=new Order(2,userID,venueID,state,order_time,start_time.plusHours(4),hours,total);
        List<Order> orders=new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        when(orderService.findUserOrder(userID,order_pageable)).thenReturn(new PageImpl<>(orders,order_pageable,1));
        when(orderVoService.returnVo(any())).thenReturn(null);
        ResultActions perform=mockMvc.perform(get("/getOrderList.do").sessionAttr("user",user).param("page","1"));
        perform.andExpect(status().isOk());
        verify(orderService).findUserOrder(userID,order_pageable);
        verify(orderVoService).returnVo(any());
    }

    @Test
    public void UT_TD_FUN_004_007_001() throws Exception {
        User user=new User();
        user.setUserID("user");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date= LocalDateTime.now().minusDays(1);
        String dateStr = date.format(df);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                                .param("venueName","venue").param("date","").param("startTime",dateStr)
                                .param("hours","1")));
        assertTrue(thrown.getMessage().contains("订单开始日期异常！"));
    }

    @Test
    public void UT_TD_FUN_004_008_001() throws Exception {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date= LocalDateTime.now().plusDays(1);
        String dateStr = date.format(df);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addOrder.do")
                                .param("venueName","venue").param("date","").param("startTime",dateStr)
                                .param("hours","1")));
        System.out.println(thrown.getMessage());
        assertTrue(thrown.getMessage().contains("请登录！"));
    }

    @Test
    public void UT_TD_FUN_004_009_001() throws Exception {

        User user=new User();
        user.setUserID("user");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date= LocalDateTime.now().plusDays(1);
        String dateStr = date.format(df);
        ResultActions perform=mockMvc.perform(post("/addOrder.do").sessionAttr("user",user)
                .param("venueName","venue").param("date","").param("startTime",dateStr)
                .param("hours","1"));
        perform.andExpect(redirectedUrl("order_manage"));
        verify(orderService).submit(anyString(),any(),anyInt(),anyString());
    }

    @Test
    public void UT_TD_FUN_004_010_001() throws Exception {

        User user=new User();
        user.setUserID("user");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date= LocalDateTime.now().minusDays(1);
        String dateStr = date.format(df);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyOrder").sessionAttr("user",user)
                                .param("venueName","venue").param("date","").param("startTime",dateStr)
                                .param("hours","1").param("orderID","1")));
        assertTrue(thrown.getMessage().contains("订单开始日期异常！"));
    }

    @Test
    public void UT_TD_FUN_004_011_001() throws Exception {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date= LocalDateTime.now().plusDays(1);
        String dateStr = date.format(df);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyOrder")
                                .param("venueName","venue").param("date","").param("startTime",dateStr)
                                .param("hours","1").param("orderID","1")));
        assertTrue(thrown.getMessage().contains("请登录！"));
    }

    @Test
    public void UT_TD_FUN_004_012_001() throws Exception {

        User user=new User();
        user.setUserID("user");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date= LocalDateTime.now().plusDays(1);
        String dateStr = date.format(df);

        ResultActions perform=mockMvc.perform(post("/modifyOrder").sessionAttr("user",user)
                .param("venueName","venue").param("date","").param("startTime",dateStr)
                .param("hours","1").param("orderID","1"));
        perform.andExpect(redirectedUrl("order_manage"));
        verify(orderService).updateOrder(anyInt(),anyString(),any(),anyInt(),anyString());
    }

    @Test
    public void UT_TD_FUN_004_013_001() throws Exception {


        when(venueService.findByVenueName(anyString())).thenReturn(null);
        when(orderService.findDateOrder(anyInt(),any(),any())).thenReturn(null);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(get("/order/getOrderList.do")
                                .param("venueName","venue")
                                .param("date","2019-12-22")));
        assertTrue(thrown.getMessage().contains("venueName不存在！"));
    }

    @Test
    public void UT_TD_FUN_004_014_001() throws Exception {
        when(venueService.findByVenueName(anyString())).thenReturn(new Venue());
        when(orderService.findDateOrder(anyInt(),any(),any())).thenReturn(null);

        mockMvc.perform(get("/order/getOrderList.do")
                .param("venueName","venue")
                .param("date","2019-12-22"))
                .andExpect(status().isOk());
        verify(venueService).findByVenueName(anyString());
        verify(orderService).findDateOrder(anyInt(),any(),any());
    }

    @Test
    public void UT_TD_FUN_004_015_001()throws Exception {
        mockMvc.perform(get("/order_place")).andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_004_016_001() throws Exception{
        ResultActions perform=mockMvc.perform(post("/finishOrder.do").param("orderID","1"));
        perform.andExpect(status().isOk());
        verify(orderService).finishOrder(anyInt());
    }

    @Test
    public void UT_TD_FUN_004_017_001() throws Exception{
        when(orderService.findById(anyInt())).thenReturn(new Order());
        when(venueService.findByVenueID(anyInt())).thenReturn(new Venue());
        ResultActions perform=mockMvc.perform(get("/modifyOrder.do").param("orderID","1"));
        ModelAndView mv=perform.andReturn().getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"venue");
        assertModelAttributeAvailable(mv,"order");
    }
    @Test
    public void UT_TD_FUN_004_017_002() throws Exception{

        when(orderService.findById(anyInt())).thenThrow(new RuntimeException());
        when(venueService.findByVenueID(anyInt())).thenReturn(new Venue());
        ResultActions perform=mockMvc.perform(get("/modifyOrder.do").param("orderID","1"));
        perform.andExpect(status().isOk()).andExpect(view().name("/index"));
    }
    @Test
    public void UT_TD_FUN_004_017_003() throws Exception{
        when(orderService.findById(anyInt())).thenReturn(new Order());
        when(venueService.findByVenueID(anyInt())).thenThrow(new RuntimeException());
        ResultActions perform=mockMvc.perform(get("/modifyOrder.do").param("orderID","1"));
        perform.andExpect(status().isOk()).andExpect(view().name("/index"));
    }

    @Test
    public void UT_TD_FUN_004_018_001()throws Exception {
        mockMvc.perform(post("/delOrder.do").param("orderID","1")).andExpect(status().isOk()).andExpect(content().string("true"));
        verify(orderService).delOrder(anyInt());
    }
}