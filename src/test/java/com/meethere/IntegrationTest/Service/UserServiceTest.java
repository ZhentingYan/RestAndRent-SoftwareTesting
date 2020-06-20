package com.meethere.IntegrationTest.Service;

import com.meethere.MeetHereApplication;
import com.meethere.entity.User;
import com.meethere.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void IT_TD_006_001_001_001() {
        String userID="test";
        User res=userService.findByUserID(userID);
        assertEquals("test",res.getUserName());
    }
    @Test
    void IT_TD_006_001_002_001() {
        String userID="测试";
        User res=userService.findByUserID(userID);
        assertNull(res);
    }
    @Test
    void IT_TD_006_002_001_001() {
        int id=1;
        User res=userService.findById(id);
        assertEquals(id,res.getId());
        assertEquals("test",res.getUserID());
    }
    @Test
    void IT_TD_006_002_002_001() {
        int id=250;
        User res=userService.findById(id);
        assertNull(res);
    }
    @Test
    void IT_TD_006_004_001_001() {
        String userID="test";
        String password="test";
        User res=userService.checkLogin(userID,password);
        assertEquals(userID,res.getUserID());
        assertEquals(password,res.getPassword());
    }
    @Test
    void IT_TD_006_004_001_002() {
        String userID="test";
        String password="wrong";
        User res=userService.checkLogin(userID,password);
        assertNull(res);
    }
    @Test
    void IT_TD_006_004_001_003() {
        String userID="wrong";
        String password="wrong";
        User res=userService.checkLogin(userID,password);
        assertNull(res);
    }

    @Test
    void IT_TD_006_005_001_001() {
        int id=1;
        String userID="test";
        String password="password";
        String email="222@qq.com";
        String phone="12345678901";
        int isadmin=0;
        String user_name="nickname";
        String picture="picture";
        User user=new User(id,userID,user_name,password,email,phone,isadmin,picture);
        int res=userService.create(user);
        assertTrue(res>0);
    }

    @Test
    public void IT_TD_006_006_001_001(){
        userService.delByID(1);
    }

    @Test
    public void IT_TD_006_006_002_001(){
        assertThrows(EmptyResultDataAccessException.class,
                ()-> userService.delByID(250));
    }

    @Test
    void IT_TD_006_008_001_001() {
        String userID="test";
        int res1=userService.countUserID(userID);
        assertEquals(1,res1);
    }
    @Test
    void IT_TD_006_008_002_001() {
        String userID="测试";
        int res1=userService.countUserID(userID);
        assertEquals(0,res1);
    }
}
