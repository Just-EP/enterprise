package pers.demo.enterprise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.demo.enterprise.utils.CommonUtils;
import pers.demo.enterprise.utils.SnowflakeIdWorker;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/13 15:27
 */
@Configuration
public class BeanConfig {
    @Bean("snowflakeIdWorker")
    SnowflakeIdWorker snowflakeIdWorker(){
        return new SnowflakeIdWorker(CommonUtils.makeWorkerId());
    }
}
