package com.yuan.Controller;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 18335 on 2018/11/24.
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("userName") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        Jedis jedis = null;
        try {
            //1.生成一个jedis对象，这个对象负责和指定的redis节点进行通信
            //本质tcp连接，内部使用socket技术，所以涉及到连接超时
            //jedis = new Jedis("127.0.0.1",6379);
            //2.jedis执行set操作
            //jedis.set("hello","world");
            //3.jedis执行get操作
            String result = jedis.get("hello");

            System.out.print(result);

            //Jedis(String host, int port, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier)
            //host:Redis 节点的所在机器的IP
            //port:端口号
            //connectiontimeout：客户端连接超时
            //soTimeout: 读写超时

            //初始化连接池，通常讲jedis pool是单例的
            //GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            //JedisPool jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379);

            //Jedis jedis1 = null;
            /*try{
                //1.从连接池获取对象
                jedis1 = jedisPool.getResource();
                //2.执行操作
                jedis1.set("java","hahaha");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(jedis1 !=null){
                    //如果使用JedisPool,close操作不是关闭连接，代表归还连接
                    jedis1.close();
                }
            }*/



        }catch (Exception e){

        }finally {
            if(jedis!=null){
                jedis.quit();
            }
        }


        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登陆失败

            map.put("msg","用户名密码错误");
            return  "login";
        }

    }
}
