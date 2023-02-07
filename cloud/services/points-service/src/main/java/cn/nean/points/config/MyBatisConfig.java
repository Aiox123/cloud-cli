package cn.nean.points.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author nean
 */
@MapperScan("cn.nean.points.mapper")
@Configuration
public class MyBatisConfig {

}
