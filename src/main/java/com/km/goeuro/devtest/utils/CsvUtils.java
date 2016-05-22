package com.km.goeuro.devtest.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.km.goeuro.devtest.domain.PositionDomain;

public class CsvUtils 
{
	private static final Logger logger = LoggerFactory.getLogger(CsvUtils.class);
	private static CsvMapper mapper = new CsvMapper();
	
	public static void toCsv(PositionDomain[] positions)
	{
		// mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CsvSchema schema = mapper.schemaFor(PositionDomain.class).withHeader();
		try {
			ObjectWriter writer = mapper.writer(schema);
			FileOutputStream tempFileOutputStream = new FileOutputStream(new File("positions.csv"));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
			OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
			writer.writeValue(writerOutputStream, positions);
		} catch (IOException e) 
		{
			logger.error("There was an error writing to file.");
			e.printStackTrace();
		}
	}
}
