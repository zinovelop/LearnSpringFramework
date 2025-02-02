package com.jinho.learnspringframework.example.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    @Component
    class ClassA {
    }

    @Component
    @Lazy
    class ClassB {
        private ClassA classA;
        public ClassB(ClassA classA) {
            System.out.println("Some Initialization Logic");
            this.classA = classA;
        }
    }


    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
            System.out.println("Initialization of context is Complete!");
            context.getBean(ClassB.class);
        }
    }
}

