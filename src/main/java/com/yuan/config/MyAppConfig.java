package com.yuan.config;

import com.yuan.Controller.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 18335 on 2018/11/20.
 */

/**
 * 指明当前类是一个配置类：提代之前spring配置文件
 *
 */
@Configuration
public class MyAppConfig {
    //将此方法的返回值添加到容器中：容器中这个组件默认的id 就是方法名
    @Bean
    public HelloService helloService() {
        return new HelloService();


    }
}
