package com.doper.controller;

import com.doper.pojo.User;
import com.doper.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestParam("name") String name, @RequestParam("pwd") String pwd) throws JsonProcessingException {
        Map<String , Object> res = new HashMap<>();
        User user= userService.getUserByName(name);
        if(user == null) {
            res.put("msg", "login fail, no this user");
            res.put("code", 400);
        } else if(!BCrypt.checkpw(pwd, user.getPassword())) {
            res.put("msg", "login fail, password err");
            res.put("code", 400);
        } else {
            res.put("msg", "ok");
            res.put("code", 200);
            res.put("token", "xxx");
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(res);
    }
}
