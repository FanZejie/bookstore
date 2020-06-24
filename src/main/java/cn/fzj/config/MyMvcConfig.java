package cn.fzj.config;

import cn.fzj.component.LoginHandlerInterceptor;
import cn.fzj.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/personalCenter.html").setViewName("personalCenter");
        registry.addViewController("/personal_left.html").setViewName("personal_left");
        registry.addViewController("/personal_main.html").setViewName("personal_main");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/pushNeed.html").setViewName("pushNeed");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/saleBook.html").setViewName("saleBook");
        registry.addViewController("/updateInfo_name.html").setViewName("updateInfo_name");
        registry.addViewController("/updateInfo_password.html").setViewName("updateInfo_password");
        registry.addViewController("/showMyNeed.html").setViewName("showMyNeed");
        registry.addViewController("/showMySupply.html").setViewName("showMySupply");

    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/login.html","/checkCode")
                .excludePathPatterns("/register.html")
                .excludePathPatterns("/layui/**");
    }
}
