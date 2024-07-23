package com.cbt.cbtjul24template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Cbtjul24templateApplication
{
    public static void main(String[] args)
    {
        new SpringApplicationBuilder()
                .profiles(args[0])
                .sources(Cbtjul24templateApplication.class)
                .run(args);
    }
}
