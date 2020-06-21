package com.meethere.IntegrationTest.Service;

import com.meethere.MeetHereApplication;
import com.meethere.entity.Order;
import com.meethere.entity.User;
import com.meethere.entity.Venue;
import com.meethere.service.OrderService;
import com.meethere.service.UserService;
import com.meethere.service.VenueService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@Transactional
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void IT_TD_STATE_002_001_001(){
        String userID="test";
        LocalDateTime start_time= LocalDateTime.now().plusDays(1);
        int hours=3;
        String venueName="同济大学嘉定校区图书馆14楼1405室";
        int res=orderService.submit(venueName,start_time,hours,userID);
        assertTrue(res>0);
    }
    @Test
    public void IT_TD_STATE_002_001_002(){
        String userID="test";
        LocalDateTime start_time= LocalDateTime.now().minusDays(1);
        int hours=3;
        String venueName="同济大学嘉定校区图书馆14楼1405室";
        assertThrows(RuntimeException.class,()->orderService.submit(venueName,start_time,hours,userID));
    }
    @Test
    public void IT_TD_STATE_002_001_003(){
        String userID="test";
        LocalDateTime start_time= LocalDateTime.now().plusDays(1);
        int hours=3;
        String venueName="不存在的共享空间";
        assertThrows(RuntimeException.class,()->orderService.submit(venueName,start_time,hours,userID));
    }
    @Test
    public void IT_TD_STATE_002_001_004(){
        String userID="test";
        LocalDateTime start_time= LocalDateTime.now().minusDays(1);
        int hours=3;
        String venueName="不存在的共享空间";
        assertThrows(RuntimeException.class,()->orderService.submit(venueName,start_time,hours,userID));

    }
    @Test
    public void IT_TD_STATE_002_001_005(){
        String userID="wrong";
        LocalDateTime start_time= LocalDateTime.now().plusDays(1);
        int hours=3;
        String venueName="同济大学嘉定校区图书馆14楼1405室";
        assertThrows(RuntimeException.class,()->orderService.submit(venueName,start_time,hours,userID));

    }
    @Test
    public void IT_TD_STATE_002_001_006(){
        String userID="wrong";
        LocalDateTime start_time= LocalDateTime.now().minusDays(1);
        int hours=3;
        String venueName="同济大学嘉定校区图书馆14楼1405室";
        assertThrows(RuntimeException.class,()->orderService.submit(venueName,start_time,hours,userID));

    }
    @Test
    public void IT_TD_STATE_002_001_007(){
        String userID="wrong";
        LocalDateTime start_time= LocalDateTime.now().plusDays(1);
        int hours=3;
        String venueName="不存在的共享空间";
        assertThrows(RuntimeException.class,()->orderService.submit(venueName,start_time,hours,userID));

    }
    @Test
    public void IT_TD_STATE_002_001_008(){
        String userID="wrong";
        LocalDateTime start_time= LocalDateTime.now().minusDays(1);
        int hours=3;
        String venueName="不存在的共享空间";
        assertThrows(RuntimeException.class,()->orderService.submit(venueName,start_time,hours,userID));
    }
    @Test
    public void IT_TD_STATE_002_002_001(){
        int orderID=33;
        orderService.confirmOrder(orderID);
    }
    @Test
    public void IT_TD_STATE_002_002_002(){
        int orderID=250;
        assertThrows(RuntimeException.class,
                ()->orderService.confirmOrder(orderID));
    }
    @Test
    public void IT_TD_STATE_002_003_001(){
        int orderID=33;
        orderService.rejectOrder(orderID);
    }
    @Test
    public void IT_TD_STATE_002_003_002(){
        int orderID=250;
        assertThrows(RuntimeException.class,
                ()->orderService.rejectOrder(orderID));
    }
    @Test
    public void IT_TD_STATE_002_004_001(){
        int orderID=33;
        orderService.delOrder(orderID);
    }
    @Test
    public void IT_TD_STATE_002_004_002(){
        int orderID=250;
        assertThrows(RuntimeException.class,
                ()->orderService.rejectOrder(orderID));
    }
    @Test
    public void IT_TD_STATE_002_006_001(){
        int orderID=33;
        orderService.delOrder(orderID);
    }
    @Test
    public void IT_TD_STATE_002_006_002(){
        int orderID=250;
        assertThrows(RuntimeException.class,
                ()->orderService.rejectOrder(orderID));
    }
    @Test
    void IT_TD_004_002_001_001() {
        int venueID=29;
        LocalDateTime start_time= LocalDateTime.now();
        List<Order> res=orderService.findDateOrder(venueID,start_time,start_time.plusDays(1));
        assertEquals(0,res.size());
    }
    @Test
    void IT_TD_004_002_001_002() {
        int venueID=250;
        LocalDateTime start_time= LocalDateTime.now();
        assertThrows(RuntimeException.class,
                ()->orderService.findDateOrder(venueID,start_time,start_time.minusDays(1)));
    }
    @Test
    void IT_TD_004_002_001_003() {
        int venueID=29;
        LocalDateTime start_time= LocalDateTime.now();
        List<Order> res=orderService.findDateOrder(venueID,start_time,start_time.plusDays(1));
        assertEquals(0,res.size());
    }
    @Test
    void IT_TD_004_002_001_004() {
        int venueID=250;
        LocalDateTime start_time= LocalDateTime.now();
        assertThrows(RuntimeException.class,
                ()->orderService.findDateOrder(venueID,start_time,start_time.minusDays(1)));
    }
    @Test
    void find_order_by_orderID() {
        int orderID=1;

        Order res=orderService.findById(orderID);
        assertEquals(orderID,res.getOrderID());
    }


    @Test
    void find_order_list_on_someday() {
        int venueID=250;
        LocalDateTime start_time= LocalDateTime.now().plusDays(1);
        List<Order> res=orderService.findDateOrder(venueID,start_time,start_time.minusDays(1));
        assertEquals(0,res.size());
    }

    @Test
    void find_user_orders() {
        String user="user";
        Pageable pageable= PageRequest.of(0,10);
        List<Order> orders= orderService.findUserOrder(user,pageable).getContent();
        for(Order o:orders){
            assertEquals(user,o.getUserID());
        }
    }



    @Test
    void return_noAudit_order_paged() {
        int state=1;
        Pageable pageable=PageRequest.of(0,10);
        List<Order> orders= orderService.findNoAuditOrder(pageable).getContent();
        for(Order o:orders){
            assertEquals(state,o.getState());
        }
    }

    @Test
    void  return_audit_order_paged() {
       orderService.findAuditOrder();
    }
}
