package cn.nean.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author nean
 */
@MapperScan("cn.nean.order.mapper")
@Configuration
public class MyBatisConfig {

}
