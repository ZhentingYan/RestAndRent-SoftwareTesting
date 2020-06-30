package com.meethere.UnitTest;

import com.meethere.controller.admin.AdminVenueController;
import com.meethere.entity.Venue;
import com.meethere.service.VenueService;
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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminVenueController.class)
class AdminVenueControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VenueService venueService;

    @Test
    public void UT_TD_FUN_003_001_001()  throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        when(venueService.create(any())).thenReturn(1);
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","this is address")
                        .param("description","this is description").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
        verify(venueService).create(any());
    }

    @Test
    public void UT_TD_FUN_003_002_001()  throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxxx.jpg",
                "picture", "".getBytes());
        when(venueService.create(any())).thenReturn(1);
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","this is address")
                        .param("description","this is description").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
        verify(venueService).create(any());
    }

    @Test
    public void UT_TD_FUN_003_003_001()  throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        when(venueService.create(any())).thenReturn(-1);
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","this is address")
                        .param("description","this is description").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        assertEquals(perform.andReturn().getRequest().getAttribute("message"),"添加失败！");
        perform.andExpect(redirectedUrl("venue_add"));
        verify(venueService).create(any());
    }

    @Test
    public void UT_TD_FUN_003_004_001()  throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxxx.jpg",
                "picture", "".getBytes());
        when(venueService.create(any())).thenReturn(-1);
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","this is address")
                        .param("description","this is description").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        assertEquals(perform.andReturn().getRequest().getAttribute("message"),"添加失败！");
        perform.andExpect(redirectedUrl("venue_add"));
        verify(venueService).create(any());
    }

    @Test
    public void UT_TD_FUN_003_005_001()  throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxxx.jpg",
                "picture", "".getBytes());
        when(venueService.create(any())).thenThrow(new RuntimeException());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","this is address")
                        .param("description","this is description").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(builder));
        assertTrue(thrown.getMessage().contains("字段长度过长，请重新修改！"));
    }

    @Test
    public void UT_TD_FUN_003_006_001()  throws Exception{
        when(venueService.findByVenueID(anyInt())).thenReturn(new Venue());

        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());

        String address= RandomStringUtils.randomAlphanumeric(256);
        String description=RandomStringUtils.randomAlphanumeric(1000);
        String open_time= RandomStringUtils.randomAlphanumeric(255);
        String close_time=RandomStringUtils.randomAlphanumeric(255);


        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address",address)
                        .param("description",description).param("price","100")
                        .param("open_time",open_time).param("close_time",close_time);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(builder));
        assertTrue(thrown.getMessage().contains("字段长度过长，请重新修改！"));
    }

    @Test
    public void UT_TD_FUN_003_007_001()  throws Exception{
        when(venueService.findByVenueID(anyInt())).thenReturn(new Venue());

        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());

        String address= RandomStringUtils.randomAlphanumeric(255);
        String description=RandomStringUtils.randomAlphanumeric(1001);
        String open_time= RandomStringUtils.randomAlphanumeric(255);
        String close_time=RandomStringUtils.randomAlphanumeric(255);


        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address",address)
                        .param("description",description).param("price","100")
                        .param("open_time",open_time).param("close_time",close_time);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(builder));
        assertTrue(thrown.getMessage().contains("字段长度过长，请重新修改！"));
    }

    @Test
    public void UT_TD_FUN_003_008_001()  throws Exception{
        when(venueService.findByVenueID(anyInt())).thenReturn(new Venue());

        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());

        String address= RandomStringUtils.randomAlphanumeric(255);
        String description=RandomStringUtils.randomAlphanumeric(1000);
        String open_time= RandomStringUtils.randomAlphanumeric(256);
        String close_time=RandomStringUtils.randomAlphanumeric(255);


        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address",address)
                        .param("description",description).param("price","100")
                        .param("open_time",open_time).param("close_time",close_time);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(builder));
        assertTrue(thrown.getMessage().contains("字段长度过长，请重新修改！"));
    }

    @Test
    public void UT_TD_FUN_003_009_001()  throws Exception{
        when(venueService.findByVenueID(anyInt())).thenReturn(new Venue());

        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());

        String address= RandomStringUtils.randomAlphanumeric(255);
        String description=RandomStringUtils.randomAlphanumeric(1000);
        String open_time= RandomStringUtils.randomAlphanumeric(255);
        String close_time=RandomStringUtils.randomAlphanumeric(256);


        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address",address)
                        .param("description",description).param("price","100")
                        .param("open_time",open_time).param("close_time",close_time);

        NestedServletException thrown =
                assertThrows(NestedServletException.class,
                        () -> mockMvc.perform(builder));
        assertTrue(thrown.getMessage().contains("字段长度过长，请重新修改！"));
    }

    @Test
    public void UT_TD_FUN_003_010_001()  throws Exception{
        when(venueService.findByVenueID(anyInt())).thenReturn(new Venue());

        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());

        String address= RandomStringUtils.randomAlphanumeric(255);
        String description=RandomStringUtils.randomAlphanumeric(1000);
        String open_time= RandomStringUtils.randomAlphanumeric(255);
        String close_time=RandomStringUtils.randomAlphanumeric(255);


        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address",address)
                        .param("description",description).param("price","100")
                        .param("open_time",open_time).param("close_time",close_time);

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
        verify(venueService).findByVenueID(anyInt());
        verify(venueService).update(any());
    }

    @Test
    public void UT_TD_FUN_003_011_001()  throws Exception{
        when(venueService.findByVenueID(anyInt())).thenReturn(new Venue());

        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","xxx.jpg",
                "picture", "".getBytes());

        String address= RandomStringUtils.randomAlphanumeric(255);
        String description=RandomStringUtils.randomAlphanumeric(1000);
        String open_time= RandomStringUtils.randomAlphanumeric(255);
        String close_time=RandomStringUtils.randomAlphanumeric(255);


        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address",address)
                        .param("description",description).param("price","100")
                        .param("open_time",open_time).param("close_time",close_time);

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
        verify(venueService).findByVenueID(anyInt());
        verify(venueService).update(any());
    }

    @Test
    public void UT_TD_FUN_003_012_001() throws Exception {
        int venueID=1;
        String venue_name="venue";
        String description="this is description";
        int price=100;
        String picture="";
        String address="address";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        List<Venue> venues=new ArrayList<>();
        venues.add(venue);
        Pageable pageable= PageRequest.of(0,10, Sort.by("venueID").ascending());

        when(venueService.findAll(pageable)).thenReturn(new PageImpl<>(venues,pageable,1));
        ResultActions perform=mockMvc.perform(get("/venue_manage"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"total");
        verify(venueService).findAll(pageable);
    }

    @Test
    public void UT_TD_FUN_003_013_001() throws Exception {
        int venueID=1;
        String venue_name="venue";
        String description="this is description";
        int price=100;
        String picture="";
        String address="address";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        when(venueService.findByVenueID(venueID)).thenReturn(venue);

        ResultActions perform=mockMvc.perform(get("/venue_edit").param("venueID","1"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"venue");
        verify(venueService).findByVenueID(venueID);
    }

    @Test
    public void UT_TD_FUN_003_014_001() throws Exception {
        ResultActions perform=mockMvc.perform(get("/venue_add"));
        perform.andExpect(status().isOk());
    }

    @Test
    public void UT_TD_FUN_003_015_001()  throws Exception{
        int venueID=1;
        String venue_name="venue";
        String description="this is description";
        int price=100;
        String picture="";
        String address="address";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        List<Venue> venues=new ArrayList<>();
        venues.add(venue);
        Pageable pageable= PageRequest.of(0,10, Sort.by("venueID").ascending());

        when(venueService.findAll(pageable)).thenReturn(new PageImpl<>(venues,pageable,1));
        ResultActions perform=mockMvc.perform(get("/venueList.do").param("page","1"));
        perform.andExpect(status().isOk());
        verify(venueService).findAll(pageable);
    }

    @Test
    public void UT_TD_FUN_003_016_001() throws Exception {

        ResultActions perform=mockMvc.perform(post("/delVenue.do").param("venueID","1"));
        perform.andExpect(status().isOk());
        verify(venueService).delById(anyInt());
    }

    @Test
    public void UT_TD_FUN_003_017_001()  throws Exception{
        when(venueService.countVenueName("venue")).thenReturn(1);
        ResultActions perform=mockMvc.perform(post("/checkVenueName.do").param("venueName","venue"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
        verify(venueService).countVenueName("venue");
    }

    @Test
    public void UT_TD_FUN_003_018_001()  throws Exception{
        when(venueService.countVenueName("venue")).thenReturn(0);
        ResultActions perform=mockMvc.perform(post("/checkVenueName.do").param("venueName","venue"));
        perform.andExpect(status().isOk()).andExpect(content().string("true"));
        verify(venueService).countVenueName("venue");
    }
}