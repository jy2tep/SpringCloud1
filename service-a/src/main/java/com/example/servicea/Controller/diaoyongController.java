package com.example.servicea.Controller;

import com.example.servicea.VipForms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
//实现不同子服务之间的调用
@EnableFeignClients
public class diaoyongController {
    @Autowired
    ServcieAClients servcieAClients;
    @RequestMapping("ceshi")
    public String ceshi(@RequestBody VipForms vipForm1){
        String result = servcieAClients.Test(vipForm1);
        return result;
    }

}
