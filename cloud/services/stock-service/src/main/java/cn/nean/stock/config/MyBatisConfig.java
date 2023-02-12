package cn.nean.stock.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author nean
 */
@MapperScan("cn.nean.stock.mapper")
@Configuration
public class MyBatisConfig {

}
