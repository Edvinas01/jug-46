package com.edd.jug46;

import com.edd.jug46.configuration.BeanInitializer;
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
