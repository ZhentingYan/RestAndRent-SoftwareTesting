package com.meethere.IntegrationTest.Controller;

import com.meethere.MeetHereApplication;
import com.meethere.entity.Message;
import com.meethere.entity.News;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@AutoConfigureMockMvc
@Transactional
public class IndexApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void IT_TD_008_002_001_001() throws Exception{
        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=1;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        ResultActions perform=mockMvc.perform(get("/admin_index").sessionAttr("admin",user));
        perform.andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void IT_TD_008_002_002_001() throws Exception{
        int id=1;
        String userID="user";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        mockMvc.perform(get("/admin_index").sessionAttr("user",user)).andExpect(status().isOk()).andExpect(view().name("index"));
    }
    @Test
    public void IT_TD_008_002_003_001() throws Exception{
        mockMvc.perform(get("/admin_index")).andExpect(status().isOk()).andExpect(view().name("login"));
    }
    //ResultActions perform=mockMvc.perform(get("/admin_index"));
    //perform.andExpect(status().isOk()).andDo(print());
    @Test
    public void IT_TD_008_001_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(get("/index"));
        perform.andExpect(status().isOk());

        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        assertAll("",()-> assertModelAttributeAvailable(mv,"user"),
                ()-> assertModelAttributeAvailable(mv,"news_list"),
                ()->assertModelAttributeAvailable(mv,"venue_list"),
                ()->assertModelAttributeAvailable(mv,"message_list"));

    }
    @Test
    public void IT_TD_008_001_001_002() throws Exception {
        ResultActions perform=mockMvc.perform(get("/"));
        perform.andExpect(status().isOk());

        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        assertAll("",()-> assertModelAttributeAvailable(mv,"user"),
                ()-> assertModelAttributeAvailable(mv,"news_list"),
                ()->assertModelAttributeAvailable(mv,"venue_list"),
                ()->assertModelAttributeAvailable(mv,"message_list"));

    }
}
