package com.meethere.IntegrationTest.Controller.Admin;

import com.meethere.MeetHereApplication;
import com.meethere.entity.User;
import org.junit.jupiter.api.Nested;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
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
public class AdminUserApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void IT_TD_012_001_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(get("/user_manage"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"total");
    }


    @Test
    public void IT_TD_012_003_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(get("/userList.do").param("page","1"));
        perform.andExpect(status().isOk());
    }
    @Test
    public void IT_TD_012_004_001_001() throws Exception{
        ResultActions perform=mockMvc.perform(get("/user_edit").param("id","1"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"user");

    }
    @Test
    public void IT_TD_012_004_001_002() throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(get("/user_edit").param("id","250")),"用户ID不存在！");
    }

    @Test
    public void IT_TD_012_006_001_001() throws Exception{
        ResultActions perform=mockMvc.perform(post("/addUser.do").param("userID","test").param("name","test").param("password","test")
                .param("email","test@qq.com").param("phone","18918599239"));
        perform.andExpect(redirectedUrl("user_manage"));
    }
    @Test
    public void IT_TD_012_006_001_002() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/addUser.do").param("userID","test").param("name","test").param("password","test")
                        .param("email","test").param("phone","1891859"))
        );
    }
    @Test
    public void IT_TD_012_006_001_003() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/addUser.do").param("userID","test").param("name","test").param("password","")
                        .param("email","test@qq.com").param("phone","1891859"))
        );
    }
    @Test
    public void IT_TD_012_006_001_004() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/addUser.do").param("userID","test").param("name","test").param("password","")
                        .param("email","test").param("phone","18918599239"))
        );
    }
    @Test
    public void IT_TD_012_006_001_005() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/addUser.do").param("userID","test").param("name","").param("password","test")
                        .param("email","test@qq.com").param("phone","1891859"))
        );
    }
    @Test
    public void IT_TD_012_006_001_006() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/addUser.do").param("userID","test").param("name","").param("password","test")
                        .param("email","test").param("phone","18918599239"))
        );
    }
    @Test
    public void IT_TD_012_006_001_007() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/addUser.do").param("userID","test").param("name","").param("password","")
                        .param("email","test@qq.com").param("phone","18918599239"))
        );
    }
    @Test
    public void IT_TD_012_006_001_008() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/addUser.do").param("userID","test").param("name","").param("password","")
                        .param("email","test").param("phone","1891859"))
        );
    }
    @Test
    public void IT_TD_012_007_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(post("/checkUserID.do").param("userID","test"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }

    @Test
    public void IT_TD_012_007_001_002() throws Exception {
        ResultActions perform=mockMvc.perform(post("/checkUserID.do").param("userID","wrong"));
        perform.andExpect(status().isOk()).andExpect(content().string("true"));

    }

    @Test
    public void IT_TD_012_008_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(post("/delUser.do").param("id","1"));
        perform.andExpect(status().isOk());
    }
    @Test
    public void IT_TD_012_008_001_002() throws Exception{
        assertThrows(NestedServletException.class,()->mockMvc.perform(post("/delUser.do").param("id","250")));
    }
}
