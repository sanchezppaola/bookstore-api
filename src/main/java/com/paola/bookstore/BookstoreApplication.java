package com.paola.bookstore;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class BookstoreApplication {

	 @Bean(initMethod = "start", destroyMethod = "stop")
	    public Server h2Server() throws SQLException {
	        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	  
	 } 
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	
	
  
    }
}




