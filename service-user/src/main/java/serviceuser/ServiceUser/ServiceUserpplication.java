package serviceuser.ServiceUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "serviceuser.ServiceUser")
@EnableDiscoveryClient
//添加注解声明自己是客户端
//@EnableEurekaClient
public class ServiceUserpplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserpplication.class, args);
    }

}
