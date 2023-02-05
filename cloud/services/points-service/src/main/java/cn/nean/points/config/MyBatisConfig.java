package cn.nean.points.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author nean
 */
@MapperScan("cn.nean.mapper")
@Configuration
public class MyBatisConfig {

}
