package serviceuser.ServiceUser.sign;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class afterResponseBody implements ResponseBodyAdvice {
    private Logger logger = Logger.getLogger(afterResponseBody.class);
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        logger.info("返回值:"+ JSON.toJSONString(o));
        logger.info("END========================================================================");
        return o;
    }
}
