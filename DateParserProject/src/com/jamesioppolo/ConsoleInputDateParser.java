package com.jamesioppolo;

import java.util.Scanner;

public class ConsoleInputDateParser {

	private IDatePairParser datePairParser;
	private INumDaysCalculator numDaysCalculator;
	
	private Scanner inputReader;

	// Reads a set of text from system.in and ensures validity before passing date pairs
	// to the number of days calculator. Prints out the date pairs with the earliest date
	// first back to system.out
	public ConsoleInputDateParser(
		IDatePairParser datePairParser,
		INumDaysCalculator numDaysCalculator)
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
	    	System.out.println(datePairs.getOrderedDateString()+", "+numDays);
	    }
	}
}
