package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        for (String bean : context.getBeanDefinitionNames()) {
            Object o = context.getBean(bean);
            if (o instanceof NumberRepository) {
                NumberRepository rep = (NumberRepository) o;
            }
        }
        ((NumberUtil)context.getBean("numberUtil")).transfer(2, 1L, 2L);
    }
}

// API : perform some operations which manipulates multiple rows/tables inside a DB
// Either all the changes happen or none of them happen
// there is no middle way out
// A : Atomicity
// [x:7, y:5, z:9] ---increment()--->
// Atomic operation : transfer(int amount, int id1, int id2) {
// reduce amount from id1
// add amount to id2
// }
// .commit()