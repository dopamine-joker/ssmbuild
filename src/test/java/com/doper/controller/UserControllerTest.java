package com.doper.controller;


import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

public class UserControllerTest {

    @Test
    public void testLogin() {
        UserController userController = new UserController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        try {
            MultiValueMapAdapter<String, String> map = new LinkedMultiValueMap<>();
            map.add("name", "root");
            map.add("pwd", "123");
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/login").params(map)).andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();
            System.out.println("状态码:" + status);
            String contentAsString = response.getContentAsString();
            System.out.println("结果:" + contentAsString);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}