package com.cardlan.springboot;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//mybatis注解扫描包范围
@MapperScan(basePackages ="com.cardlan.springboot.mapper")
//扫描所需包，包含自用工具类包所在的路径
@ComponentScan(basePackages ={"com.cardlan","org.n3r.idworker"})
public class SpringbootMuxinNettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMuxinNettyApplication.class, args);
    }

}
