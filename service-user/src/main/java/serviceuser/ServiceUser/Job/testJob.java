package serviceuser.ServiceUser.Job;


import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class testJob {

    @XxlJob("demoJobHandler")
    public void execute() throws Exception {
        System.out.println("1");
    }
}