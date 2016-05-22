package com.km.goeuro.devtest;

import com.km.goeuro.devtest.domain.PositionDomain;
import com.km.goeuro.devtest.services.GoEuroService;
import com.km.goeuro.devtest.utils.CsvUtils;

public class Main {

	public static void main(String[] args) 
	{
		if(args.length == 0)
		{
			System.err.println("You need to specify a parameter, e.g. java -jar GoEuroTest.jar \"Berlin\"");
			return;
		}
		
		GoEuroService service = GoEuroService.getInstance();
		
		PositionDomain[] positions = service.getPositionSuggestions(args[0]);
		
		/* Writes to positions.csv */
		CsvUtils.toCsv(positions);
	}

}
