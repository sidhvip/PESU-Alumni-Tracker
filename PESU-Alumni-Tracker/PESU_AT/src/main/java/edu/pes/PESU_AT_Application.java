package edu.pes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
@ComponentScan({"edu.pes.*"})
@EntityScan("edu.pes.*")
@EnableJpaRepositories("edu.pes.*")
public class PESU_AT_Application  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PESU_AT_Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PESU_AT_Application.class);
    }
}

