package com.cardlan.springboot.controller;

import com.cardlan.springboot.pojo.Users;
import com.cardlan.springboot.utils.IMoocJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController

public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello 幕信";
    }


}
