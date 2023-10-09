//package serviceuser.ServiceUser.sign;
//
//import com.alibaba.fastjson.JSON;
//import lombok.SneakyThrows;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.HttpInputMessage;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
//import serviceuser.ServiceUser.Excep.UserException;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.Type;
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//@ControllerAdvice
//public class TestSign extends RequestBodyAdviceAdapter {
//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private SignTestDo signTestDo;
//    private Logger logger = Logger.getLogger(TestSign.class);
//    @Override
//    public boolean supports(MethodParameter var1, Type var2, Class<? extends HttpMessageConverter<?>> var3) {
//        return true;
//    }
//    @SneakyThrows
//    @Override
//    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
//        Map<String, Object> input = new HashMap<>();
//        Field[] fields = body.getClass().getDeclaredFields(); //获取实体类的所有属性，返回Field数组
//        logger.info("Begin===============================================================");
//        logger.info("请求路径:"+request.getRequestURI()+"\n请求参数:"+ JSON.toJSONString(body)+"请求签名"+request.getHeader("X-Sign"));
//        for (Field field : fields) {
//            String attName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
//            String type = field.getGenericType().toString();    //获取属性的类型
//            switch (type) {
//                case "class java.lang.String": {   //如果type是类类型，则前面包含"class "，后面跟类名
//                    Method method = body.getClass().getMethod("get" + attName);
//                    String value = (String) method.invoke(body);    //调用getter方法获取属性值
//                    input.put(field.getName(), value);
//                    break;
//                }
//                case "class java.lang.Integer": {
//                    Method method = body.getClass().getMethod("get" + attName);
//                    Integer value = (Integer) method.invoke(body);
//                    input.put(field.getName(), value);
//                    break;
//                }
//                case "class java.lang.Short": {
//                    Method method = body.getClass().getMethod("get" + attName);
//                    Short value = (Short) method.invoke(body);
//                    input.put(field.getName(), value);
//                    break;
//                }
//                case "class java.lang.Long": {
//                    Method method = body.getClass().getMethod("get" + attName);
//                    Long value = (Long) method.invoke(body);
//                    input.put(field.getName(), value);
//                    break;
//                }
//                case "class java.lang.Double": {
//                    Method method = body.getClass().getMethod("get" + attName);
//                    Double value = (Double) method.invoke(body);
//                    input.put(field.getName(), value);
//                    break;
//                }
//                case "class java.lang.Boolean": {
//                    Method method = body.getClass().getMethod("get" + attName);
//                    Boolean value = (Boolean) method.invoke(body);
//                    input.put(field.getName(), value);
//                    break;
//                }
//                case "class java.util.Date": {
//                    Method method = body.getClass().getMethod("get" + attName);
//                    Date value = (Date) method.invoke(body);
//                    if (value != null) {
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        String format = simpleDateFormat.format(value);
//                        input.put(field.getName(), format);
//                        break;
//                    }
//
//                }
//                case "class java.math.BigDecimal": {
//                    Method method = body.getClass().getMethod("get" + attName);
//                    BigDecimal value = (BigDecimal) method.invoke(body);
//                    if (value != null) {
//                        input.put(field.getName(), value.stripTrailingZeros().toPlainString());
//                        break;
//                    }
//
//
//                }
//            }
//        }
//        String sign = this.request.getHeader("X-Sign");
//        if (Objects.isNull(sign)) {
//            sign = this.request.getHeader("x-sign");
//        }
//        if (!signTestDo.SignPass(input,sign)){
//            throw new UserException(new ResultCode(false,-1,"签名错误"));
//        }
//        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
//    }
//}
