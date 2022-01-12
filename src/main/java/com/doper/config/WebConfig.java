package com.doper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.doper.controller")
public class WebConfig implements WebMvcConfigurer{

    //视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);
        registry.viewResolver(viewResolver);
    }

    //静态资源过滤
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //通过enable()方法要求DispatcherServlet将静态资源的请求转发到Servlet容器默认的Servlet上，而不是使用DispatcherServlet本身处理
        configurer.enable();
    }
}
