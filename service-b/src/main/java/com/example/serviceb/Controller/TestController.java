package com.example.serviceb.Controller;

import com.example.serviceb.From.VipFrom;
import com.example.serviceb.Mapper.VipDao;
import com.example.serviceb.model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class TestController {
    @Autowired
    VipDao vipDao;
    @RequestMapping(value = "TestJpa",method = RequestMethod.POST)
    public String Test(@Valid @RequestBody VipFrom vipFrom){
        Vip vip = new Vip();
        vip.setAccount(vipFrom.getAccount());
        vip.setId(vipFrom.getId());
        vip.setName(vipFrom.getName());
        vip.setMobile(vipFrom.getMobile());
        vip.setPassword(vipFrom.getPassword());
        vipDao.insertOrUpdate(vip.getName(),vip.getId());
        return vipDao.findAll().toString();
    }
}
