package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by rajasupadhye on 2/24/17.
 */
@EnableAutoConfiguration
@ComponentScan

public class TwitterDriver extends SpringBootServletInitializer {
    private static Class<TwitterDriver> appClass = TwitterDriver.class;
    private static Logger log =  LoggerFactory.getLogger(TwitterDriver.class);

    public static void main (String args[]){
        log.info("The TwitterDriver started");
        SpringApplication.run(TwitterDriver.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(appClass);
    }

}
