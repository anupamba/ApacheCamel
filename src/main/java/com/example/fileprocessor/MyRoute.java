package com.example.fileprocessor;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyRoute.class);
	private final String INPUT = "file://C:\\camel\\input/?fileName=fileadd.csv&noop=true";
	private final String OUTPUT = "file://C:\\camel\\output/?fileName=fileadd.done";

	@Override
	public void configure() throws Exception {
		LOGGER.info("Configuting the Router...");
		from(INPUT).process(new FileProcessor())
				.log("Camel body: ${body}")
                .to(OUTPUT);

	}

}
