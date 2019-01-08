package com.yuan.component;

import com.sun.corba.se.spi.orbutil.closure.Closure;
import com.sun.corba.se.spi.resolver.LocalResolver;
import org.codehaus.groovy.util.StringUtil;
import org.omg.CORBA.Object;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by 18335 on 2018/11/23.
 * 可以在请求连接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver{


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale local = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String [] arr =  l.split("_");
            String a = arr[0];
            String b = arr[1];
            local = new Locale(a,b);

        }
        return local;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
