package com.yuan.config;

import com.yuan.component.LoginHandlerInterceptor;
import com.yuan.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 18335 on 2018/11/23.
 * 使用WebMvcConfigurerAdapter扩展mvc的功能
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送into请求到success
        //既保留了原有的web自动配置，又增加了定制
        registry.addViewController("/into").setViewName("success");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    //所有的webMvcConfigurerAdapter都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //添加试图映射，设置视图名
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            //注册拦截器
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
               /* registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("*//**")
                        .excludePathPatterns("/user/login","/","/index.html")
                ;*/
            }
        };
        return adapter;
    }
    @Bean//将主键注册在容器
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
