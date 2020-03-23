package com.example.fileprocessor;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Amruta
 *This is the Sprinmg main class which starts the spring application. The camel context lifecycle is handled here.
 */
@SpringBootApplication
public class FileTransferApplication {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(FileTransferApplication.class, args);
		
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new MyRoute());
		camelContext.start(); 
		Thread.sleep(60*100);
		camelContext.stop();
		camelContext.close();

	}

}
