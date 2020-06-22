package com.meethere.IntegrationTest.Controller.User;

import com.meethere.MeetHereApplication;
import com.meethere.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@AutoConfigureMockMvc
@Transactional
public class UserApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void IT_TD_014_001_001_001() throws Exception {
        mockMvc.perform(get("/signup").sessionAttr("user",new User())).andExpect(status().isOk()).andExpect(view().name("index"));
    }
    @Test
    public void IT_TD_014_001_001_002() throws Exception {
        mockMvc.perform(get("/signup")).andExpect(status().isOk()).andExpect(view().name("signup"));
    }
    @Test
    public void IT_TD_014_002_001_001() throws Exception {
        mockMvc.perform(get("/login").sessionAttr("user",new User())).andExpect(status().isOk()).andExpect(view().name("index"));
    }
    @Test
    public void IT_TD_014_002_001_002() throws Exception {
        mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login"));
    }
    @Test
    public void IT_TD_014_002_001_003() throws Exception {
        mockMvc.perform(get("/login").sessionAttr("admin",new User())).andExpect(status().isOk()).andExpect(view().name("admin/admin_index"));
    }
    @Test
    public void IT_TD_014_003_001_001() throws Exception{
        ResultActions perform=mockMvc.perform(post("/loginCheck.do").param("userID","test").param("password","test"));
        perform.andExpect(status().isOk()).andExpect(content().string("/index"));
    }
    @Test
    public void IT_TD_014_003_001_002() throws Exception{
        ResultActions perform=mockMvc.perform(post("/loginCheck.do").param("userID","admin").param("password","admin"));
        perform.andExpect(status().isOk()).andExpect(content().string("/admin_index"));
    }
    @Test
    public void IT_TD_014_003_001_003() throws Exception{
        ResultActions perform=mockMvc.perform(post("/loginCheck.do").param("userID","").param("password",""));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }
    @Test
    public void IT_TD_014_003_001_004() throws Exception{
        ResultActions perform=mockMvc.perform(post("/loginCheck.do").param("userID","test").param("password","wrongpassword"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }
    @Test
    public void IT_TD_014_004_001_001() throws Exception{
        ResultActions perform=mockMvc.perform(post("/register.do").param("userID","test").param("name","test").param("password","test")
                .param("email","test@qq.com").param("phone","18918599239"));
        perform.andExpect(redirectedUrl("login"));
    }
    @Test
    public void IT_TD_014_004_001_002() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/register.do").param("userID","test").param("name","test").param("password","test")
                        .param("email","test").param("phone","1891859"))
        );
    }
    @Test
    public void IT_TD_014_004_001_003() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/register.do").param("userID","test").param("name","test").param("password","")
                        .param("email","test@qq.com").param("phone","1891859"))
        );
    }
    @Test
    public void IT_TD_014_004_001_004() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/register.do").param("userID","test").param("name","test").param("password","")
                        .param("email","test").param("phone","18918599239"))
        );
    }
    @Test
    public void IT_TD_014_004_001_005() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/register.do").param("userID","test").param("name","").param("password","test")
                        .param("email","test@qq.com").param("phone","1891859"))
        );
    }
    @Test
    public void IT_TD_014_004_001_006() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/register.do").param("userID","test").param("name","").param("password","test")
                        .param("email","test").param("phone","18918599239"))
        );
    }
    @Test
    public void IT_TD_014_004_001_007() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/register.do").param("userID","test").param("name","").param("password","")
                        .param("email","test@qq.com").param("phone","18918599239"))
        );
    }
    @Test
    public void IT_TD_014_004_001_008() throws Exception {
        assertThrows(NestedServletException.class,()->
                mockMvc.perform(post("/register.do").param("userID","test").param("name","").param("password","")
                        .param("email","test").param("phone","1891859"))
        );
    }

    @Test
    public void IT_TD_014_005_001_001()throws Exception {
        ResultActions perform=mockMvc.perform(get("/logout.do"));
        perform.andExpect(redirectedUrl("/index"));
    }
    @Test
    public void IT_TD_014_006_001_001()throws Exception {
        ResultActions perform=mockMvc.perform(get("/quit.do"));
        perform.andExpect(redirectedUrl("/index"));
    }

    @Test
    public void IT_TD_014_007_001_001()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","test").param("userName","name")
                        .param("passwordNew", (String) null)
                        .param("email","632950864@qq.com").param("phone","18918599239");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));
    }

    @Test
    public void IT_TD_014_007_001_002()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","test").param("userName","name")
                        .param("passwordNew", (String) null)
                        .param("email","632950864@qq.com").param("phone","18918599239");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));

    }

    @Test
    public void IT_TD_014_007_001_003()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","test").param("userName","name")
                        .param("passwordNew", "")
                        .param("email","632950864@qq.com").param("phone","18918599239");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));

    }
    @Test
    public void IT_TD_014_007_001_004()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","test").param("userName","name")
                        .param("passwordNew", "")
                        .param("email","632950864@qq.com").param("phone","18918599239");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));
    }

    @Test
    public void IT_TD_014_007_001_005()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","test").param("userName","name")
                        .param("passwordNew", "newPassword")
                        .param("email","632950864@qq.com").param("phone","18918599239");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));


    }

    @Test
    public void IT_TD_014_007_001_006()throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/updateUser.do").file(mockMultipartFile).param("userID","test").param("userName","name")
                        .param("passwordNew", "newPassword")
                        .param("email","632950864@qq.com").param("phone","18918599239");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("user_info"));
    }

    @Test
    public void IT_TD_014_008_001_001()throws Exception {
        ResultActions perform=mockMvc.perform(get("/checkPassword.do").param("userID","test").param("password","test"));
        perform.andExpect(status().isOk()).andExpect(content().string("true"));
    }
    @Test
    public void IT_TD_014_008_001_002()throws Exception {
        ResultActions perform=mockMvc.perform(get("/checkPassword.do").param("userID","admin").param("password","admin"));
        perform.andExpect(status().isOk()).andExpect(content().string("true"));
    }
    @Test
    public void IT_TD_014_008_001_003()throws Exception {
        ResultActions perform=mockMvc.perform(get("/checkPassword.do").param("userID","wrong").param("password","wrong"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }
    @Test
    public void IT_TD_014_008_001_004()throws Exception {
        ResultActions perform=mockMvc.perform(get("/checkPassword.do").param("userID","test").param("password","wrongpassword"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }
    @Test
    public void IT_TD_014_009_001_001() throws Exception{
        mockMvc.perform(get("/user_info").sessionAttr("user",new User())).andExpect(status().isOk()).andExpect(view().name("user_info"));
    }
    @Test
    public void IT_TD_014_009_001_002() throws Exception{
        mockMvc.perform(get("/user_info")).andExpect(status().isOk()).andExpect(view().name("login"));
    }
}
