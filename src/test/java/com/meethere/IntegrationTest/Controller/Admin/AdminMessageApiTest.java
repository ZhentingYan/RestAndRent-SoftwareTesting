package com.meethere.IntegrationTest.Controller.Admin;

import com.meethere.MeetHereApplication;
import com.meethere.controller.admin.AdminMessageController;
import com.meethere.entity.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@AutoConfigureMockMvc
@Transactional
public class AdminMessageApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void IT_TD_010_005_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(get("/message_manage"));
        perform.andExpect(status().isOk());

        MvcResult mvcResult=mockMvc.perform(get("/message_manage")).andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        assertModelAttributeAvailable(mv,"total");
    }

    @Test
    public void IT_TD_010_001_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(get("/messageList.do"));
        perform.andExpect(status().isOk()).andDo(print());

    }

    @Test
    public void IT_TD_010_002_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(post("/passMessage.do").param("messageID","26"));
        perform.andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void IT_TD_010_002_001_002() throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(post("/passMessage.do").param("messageID","250")),"留言不存在！");
    }
    @Test
    public void IT_TD_010_003_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(post("/rejectMessage.do").param("messageID","26"));
        perform.andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void IT_TD_010_003_001_002() throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(post("/rejectMessage.do").param("messageID","250")),"留言不存在！");
    }
    @Test
    public void IT_TD_010_004_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(post("/delMessage.do").param("messageID","26"));
        perform.andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void IT_TD_010_004_001_002() throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(post("/delMessage.do").param("messageID","250")),"留言不存在！");
    }

}
