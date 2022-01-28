package com.paola.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BookstoreApplication {

//	 @Bean(initMethod = "start", destroyMethod = "stop")
//	    public Server h2Server() throws SQLException {
//	        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
//	  
//	 } 
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	
	
  
    }
}




