package cn.fzj.config;

import cn.fzj.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean("user1")
    public User getUser1(){
        return new User(1,"fzj","aaaaaa");
    }

    @Bean("user2")
    public User getUser2(){
        return new User(2,"fzj2","aaaaaa");
    }
}
