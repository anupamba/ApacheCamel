package com.example.fileprocessor;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *This class performs the file reading and any processing required on the data.
 * @author Amruta
 *
 */
public class FileProcessor implements Processor {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FileProcessor.class);

	public void process(Exchange exchange) throws Exception {
		LOGGER.info("Processing the input file...");
		String fileOutput = "";
		try {
			String originalFileContent = (String) exchange.getIn().getBody(String.class);

			String[] lineSeparator = originalFileContent.split(System.getProperty("line.separator"));

			for (String lineData : lineSeparator) {
				int lineCounter = 0;
				StringTokenizer tokenizer = new StringTokenizer(lineData, ",");

				while (tokenizer.hasMoreElements()) {
					lineCounter += Integer.parseInt(tokenizer.nextElement().toString());
				}
				fileOutput += String.valueOf(lineCounter) + System.getProperty("line.separator");
			}
			// Input File has any error it will update output file
			if ("" == fileOutput) {
				fileOutput = "THE INPUT FILE IS EMPTY. ";
				LOGGER.error("ERROR in processing the content of the input fileThe . Please find the result value:- .", fileOutput);
			}
		} catch (Exception e) {
			fileOutput = "ERROR IN INPUT FILE! PLEASE REVIEW THE CONTENT OF THE INTIGER CSV File "
					+ e.getLocalizedMessage();
            LOGGER.error("ERROR while reading the input file. Please find the result value:- ", fileOutput);
		}
		exchange.getIn().setBody(fileOutput);
	}
}