package com.yuan.Controller;

import com.yuan.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 18335 on 2018/11/29.
 */

/**
 * springmvc异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {
    //浏览器和客户端返回的都是json数据
    /*@ResponseBody
    //标注异常
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handlerException(Exception e){
        Map<String,Object> map = new HashMap();
        map.put("code","use.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        //传入我们自己的状态码 4xx 5xx
        //        Integer statusCode = (Integer)request
        // .getAttribute("javax.servlet.error.status_code");

        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String, Object> map = new HashMap();
        map.put("code", "use.notexist");
        map.put("message", "啊啊啊");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
