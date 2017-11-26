package com.jamesioppolo;

import java.util.Scanner;

public class ConsoleInputDateParser {

	private DatePairParser datePairParser;
	private NumDaysCalculator numDaysCalculator;
	
	private Scanner inputReader;

	public ConsoleInputDateParser(
		DatePairParser datePairParser,
		NumDaysCalculator numDaysCalculator)
	{
		this.datePairParser = datePairParser;
		this.numDaysCalculator = numDaysCalculator;
	}
	
	public void execute()
	{
	    String input = null;
	    inputReader = new Scanner(System.in);
	    input = inputReader.nextLine();
	    	    
	    DatePairResultModel datePairs = datePairParser.parse(input);
	    if (!datePairs.isValid)
	    {
	    	System.out.println("Failed to parse values. Please try again.");
	    }
	    else
	    {
	    	int numDays = numDaysCalculator.getDifferenceInDaysBetween(datePairs.date1, datePairs.date2);
	    	System.out.println(input+", "+numDays);
	    }
	}
}
