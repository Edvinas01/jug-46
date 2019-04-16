package com.edd.jug46.spring;

import com.edd.jug46.spring.configuration.BeanInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        new SpringApplicationBuilder()
            .initializers(new BeanInitializer())
            .sources(Application.class)
            .run(args);
    }
}
