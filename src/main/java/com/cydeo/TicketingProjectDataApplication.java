package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class   TicketingProjectDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketingProjectDataApplication.class, args);
    }
    //i am trying to add bean in the container through @Bean annotation
    //create a class annotated with configuration annotation
    //write a method which return the object that i am trying to add in the container
    //annotate this method with @Bean

    //this is the finished product
    //we can do this as the springbootapplication annotation includes the @configuration annotation
    @Bean
    public ModelMapper mapper (){
        return new ModelMapper();
    }

}
