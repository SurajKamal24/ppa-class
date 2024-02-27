package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
        for (String bean : ctx.getBeanDefinitionNames()) {
            Object obj = ctx.getBean(bean);
            if (obj instanceof JpaRepository) {
                System.out.println(obj.getClass().getName() + " " + bean);
            }
        }
    }

}