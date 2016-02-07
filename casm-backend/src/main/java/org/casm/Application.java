package org.casm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by Shubham on 2/1/2016.
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    public static void main(String []args)
    {
        SpringApplication.run(Application.class,args);
    }
}
