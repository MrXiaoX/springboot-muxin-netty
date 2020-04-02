package com.cardlan.springboot.designpattern.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@Component("monsterConfiguration")
@ComponentScan("com.cardlan.springboot.designpattern.prototype")
public class MonsterConfiguration {

    @Bean
    @Scope(value="prototype")
    public  Monster getMonster(){
        return new Monster();
    }

}
