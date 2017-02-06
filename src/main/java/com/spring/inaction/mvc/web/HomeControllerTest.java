package com.spring.inaction.mvc.web;

import org.apache.xml.security.stax.impl.util.LimitingInputStream;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by sky on 2017/1/18.
 */
public class HomeControllerTest {
    @Test
    public void testHomePage01() throws Exception {
        HomeController01 controller = new HomeController01();
        assertEquals("home", controller.home());
    }

    //controller测试
    @Test
    public void testHomePage02() throws Exception {
        HomeController01 controller = new HomeController01();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }

/*    @Test
    public void shouldShowRecentSpittles() {
        List<Spittle> expectedSpittles = creatSpittleList(20);
        SpittleRepository mockRepository =

    }

    private List<Spittle> creatSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }*/
}
