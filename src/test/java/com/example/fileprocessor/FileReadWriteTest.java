package com.example.fileprocessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.apache.camel.CamelContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;

/**
 * 
 * @author Amruta
 * This is a test class which checks the input - output oprtaions
 *
 */


@ContextConfiguration
public class FileReadWriteTest  {

	
	  @Autowired
	    protected CamelContext camelContext;
	 

	@Test
	@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
	public void checkFileExistsInOutputDirectory() throws InterruptedException {
		Thread.sleep(5000);
		File file = new File("C://camel/output");
		assertTrue(file.isDirectory());
		assertEquals(1, file.listFiles().length);
		assertEquals("fileadd.done", file.list()[0]);

	}

}
