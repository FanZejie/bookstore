package cn.fzj.config;

import cn.fzj.pojo.Deal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DealBeanConfig {
    @Bean
    public Deal getDealBean(){
        return new Deal();
    }
}
