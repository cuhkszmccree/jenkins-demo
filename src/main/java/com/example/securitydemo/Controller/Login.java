package com.example.securitydemo.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String login(){
        return "login success";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String login2(){
        return "login success2";
    }
}
