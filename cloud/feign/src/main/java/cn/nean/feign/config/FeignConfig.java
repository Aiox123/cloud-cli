package cn.nean.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    /*
    * 日志配置
    * */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
