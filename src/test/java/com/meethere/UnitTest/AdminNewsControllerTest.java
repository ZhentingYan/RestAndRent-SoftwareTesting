package com.meethere.UnitTest;

import com.meethere.controller.admin.AdminNewsController;
import com.meethere.entity.News;
import com.meethere.service.NewsService;
import org.apache.commons.lang3.RandomStringUtils;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminNewsController.class)
public class AdminNewsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private NewsService newsService;

    @Test
    public void UT_TD_FUN_001_001_001() throws Exception{
        String content=RandomStringUtils.randomAlphanumeric(2500);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addNews.do").param("title","").param("content",content)));
        assertTrue(thrown.getMessage().contains("新建公告参数不合法！"));
    }
    @Test
    public void UT_TD_FUN_001_002_001() throws Exception{
        String title=RandomStringUtils.randomAlphanumeric(100);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addNews.do").param("title",title).param("content","")));
        assertTrue(thrown.getMessage().contains("新建公告参数不合法！"));
    }
    @Test
    public void UT_TD_FUN_001_003_001() throws Exception{
        String title=RandomStringUtils.randomAlphanumeric(110);
        String content=RandomStringUtils.randomAlphanumeric(2500);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addNews.do").param("title",title).param("content",content)));
        assertTrue(thrown.getMessage().contains("新建公告参数不合法！"));
    }
    @Test
    public void UT_TD_FUN_001_004_001() throws Exception{
        String title=RandomStringUtils.randomAlphanumeric(50);
        String content=RandomStringUtils.randomAlphanumeric(5010);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/addNews.do").param("title",title).param("content",content)));
        assertTrue(thrown.getMessage().contains("新建公告参数不合法！"));
    }
    @Test
    public void UT_TD_FUN_001_005_001() throws Exception{
        String title=RandomStringUtils.randomAlphanumeric(50);
        String content=RandomStringUtils.randomAlphanumeric(2500);
        when(newsService.create(any())).thenReturn(1);
        ResultActions perform=mockMvc.perform(post("/addNews.do").param("title",title).param("content",content));

        perform.andExpect(redirectedUrl("news_manage"));
        verify(newsService).create(any());
    }

    @Test
    public void UT_TD_FUN_001_006_001() throws Exception{
        when(newsService.findById(anyInt())).thenReturn(new News());
        String content=RandomStringUtils.randomAlphanumeric(2500);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyNews.do").param("newsID","1").param("title","").param("content",content)));
        assertTrue(thrown.getMessage().contains("修改公告参数不合法！"));
    }
    @Test
    public void UT_TD_FUN_001_007_001() throws Exception{
        when(newsService.findById(anyInt())).thenReturn(new News());
        String title=RandomStringUtils.randomAlphanumeric(100);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyNews.do").param("newsID","1").param("title",title).param("content","")));
        assertTrue(thrown.getMessage().contains("修改公告参数不合法！"));
    }
    @Test
    public void UT_TD_FUN_001_008_001() throws Exception{
        when(newsService.findById(anyInt())).thenReturn(new News());
        String title=RandomStringUtils.randomAlphanumeric(110);
        String content=RandomStringUtils.randomAlphanumeric(2500);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyNews.do").param("newsID","1").param("title",title).param("content",content)));
        assertTrue(thrown.getMessage().contains("修改公告参数不合法！"));
    }
    @Test
    public void UT_TD_FUN_001_009_001() throws Exception{
        when(newsService.findById(anyInt())).thenReturn(new News());
        String title=RandomStringUtils.randomAlphanumeric(50);
        String content=RandomStringUtils.randomAlphanumeric(5010);
        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(post("/modifyNews.do").param("newsID","1").param("title",title).param("content",content)));
        assertTrue(thrown.getMessage().contains("修改公告参数不合法！"));
    }
    @Test
    public void UT_TD_FUN_001_010_001() throws Exception{
        when(newsService.findById(anyInt())).thenReturn(new News());
        String title=RandomStringUtils.randomAlphanumeric(50);
        String content=RandomStringUtils.randomAlphanumeric(2500);
        ResultActions perform=mockMvc.perform(post("/modifyNews.do").param("newsID","1").param("title",title).param("content",content));

        perform.andExpect(redirectedUrl("news_manage"));
        verify(newsService).update(any());
    }

    @Test
    public void UT_TD_FUN_001_011_001() throws Exception{
        int id=1;
        String title="title";
        String content="this is content";
        LocalDateTime ldt=LocalDateTime.now();
        News news=new News(id,title,content,ldt);
        List<News> news1=new ArrayList<>();
        news1.add(news);
        Pageable news_pageable= PageRequest.of(0,10, Sort.by("time").ascending());
        when(newsService.findAll(news_pageable)).thenReturn(new PageImpl<>(news1,news_pageable,1));

        ResultActions perform=mockMvc.perform(get("/news_manage"));
        perform.andExpect(status().isOk());
        verify(newsService).findAll(any());
        MvcResult mvcResult=mockMvc.perform(get("/news_manage")).andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        assertModelAttributeAvailable(mv,"total");
        verify(newsService,times(2)).findAll(any());
    }

    @Test
    public void UT_TD_FUN_001_012_001()throws Exception {
        ResultActions perform=mockMvc.perform(get("/news_add"));
        perform.andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_001_013_001() throws Exception {
        int id=1;
        String title="title";
        String content="this is content";
        LocalDateTime ldt=LocalDateTime.now();
        News news=new News(id,title,content,ldt);
        when(newsService.findById(anyInt())).thenReturn(news);

        ResultActions perform=mockMvc.perform(get("/news_edit").param("newsID","1"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"news");
        verify(newsService).findById(anyInt());
    }

    @Test
    public void UT_TD_FUN_001_014_001() throws Exception {
        int id=1;
        String title="title";
        String content="this is content";
        LocalDateTime ldt=LocalDateTime.now();
        News news=new News(id,title,content,ldt);
        List<News> news1=new ArrayList<>();
        news1.add(news);
        Pageable news_pageable= PageRequest.of(1,10, Sort.by("time").ascending());
        when(newsService.findAll(any())).thenReturn(new PageImpl<>(news1,news_pageable,1));

        ResultActions perform=mockMvc.perform(get("/newsList.do").param("page","1"));
        perform.andExpect(status().isOk());
        verify(newsService).findAll(any());
    }

    @Test
    public void UT_TD_FUN_001_015_001() throws Exception {
        ResultActions perform=mockMvc.perform(post("/delNews.do").param("newsID","1"));
        perform.andExpect(status().isOk());
        verify(newsService).delById(1);
    }

    @Test
    public void UT_TD_FUN_001_016_001() throws Exception {
        when(newsService.findById(1)).thenReturn(new News());
        ResultActions perform=mockMvc.perform(post("/modifyNews.do").param("newsID","1").param("title","this is title").
                param("content","this is content"));

        perform.andExpect(redirectedUrl("news_manage"));
        verify(newsService).findById(1);
        verify(newsService).update(any());
    }
}