package com.yuan.Controller;

import com.yuan.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by 18335 on 2018/11/19.
 */
@Controller
/*@RestController*/
public class HelloController {
    @Value("${person.last-name}")
    private String name ;
    /*@ResponseBody*/
    @RequestMapping("/hello")
    private String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello"/* + name   */;
    }

    @RequestMapping("/success")
    private String success(Map<String,Object> map){
        //chasspath：templates/success.html
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
    /*@RequestMapping("/index")
    private String index(){
        return "index";
    }*/
}
