package com.example.servicea.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
    @RequestMapping("testA")
    public String TestACon(){
        return "helloSpringCloud";
    }


}
