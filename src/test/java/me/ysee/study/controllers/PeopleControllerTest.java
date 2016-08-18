package me.ysee.study.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by herosea on 16/8/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PeopleControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        //Mock单个controller的mvc
        mvc = MockMvcBuilders.standaloneSetup(new PeopleController()).build();
    }

    @Test
    public void fetch() throws Exception {
        //模拟请求
        mvc.perform(MockMvcRequestBuilders.get("/people/1000").accept(MediaType.APPLICATION_JSON))
                //断言返回状态
                .andExpect(status().isOk())
                //断言返回值
                .andExpect(content().string(equalTo("{\"name\":\"名字\",\"sex\":true,\"age\":1000}")));
    }

    @Test
    public void index() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/people").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"name\":\"用户1\",\"sex\":true,\"age\":1000},{\"name\":\"用户2\",\"sex\":false,\"age\":2000}]")));
    }
}