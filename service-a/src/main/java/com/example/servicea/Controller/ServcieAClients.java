package com.example.servicea.Controller;

        import com.example.servicea.VipForms;
        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVICE-OBJCAT-B")
public interface ServcieAClients {
    @RequestMapping("TestJpa")
    public String Test(VipForms vipForm1);
}
