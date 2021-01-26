package com.codedreamer.springBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 53137
 */
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        //返回容器
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootDemoApplication.class, args);
        //查看容器中组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
