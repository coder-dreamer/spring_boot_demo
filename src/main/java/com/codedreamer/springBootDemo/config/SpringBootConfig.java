package com.codedreamer.springBootDemo.config;

import com.codedreamer.springBootDemo.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springBoot配置类,等价于bean.xml
 *
 * @author 53137
 */
@Configuration
public class SpringBootConfig {

    /**
     * user组件，默认单例
     *
     * @return
     */
    @Bean
    public User user() {
        return new User("lhp", 18);
    }
}
