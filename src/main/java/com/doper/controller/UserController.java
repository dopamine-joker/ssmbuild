package com.doper.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestParam("name") String name, @RequestParam("pwd") String pwd) throws JsonProcessingException {
        Map<String , Object> res = new HashMap<>();
        if("root".equals(name) && "123".equals(pwd)) {
            res.put("msg", "ok");
            res.put("code", 200);
            res.put("token", "xxx");
        } else {
            res.put("msg", "login fail");
            res.put("code", 400);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(res);
    }
}
