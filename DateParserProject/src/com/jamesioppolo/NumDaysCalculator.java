package com.jamesioppolo;

interface INumDaysCalculator
{
	int getDifferenceInDaysBetween(DateModel date1, DateModel date2);
}

public class NumDaysCalculator implements INumDaysCalculator {
	
	private IDaysInMonthService daysInMonthService;
	
	public NumDaysCalculator(IDaysInMonthService daysInMonthService)
	{
		this.daysInMonthService = daysInMonthService;
	}
	
	public int getDifferenceInDaysBetween(DateModel date1, DateModel date2)
	{
		int days = 0; 
		if (isDateRangeValid(date1, date2))
		{
			// Calculate the number of leap years across the beginning and end dates
			int numLeapYearsInDateRange = 0; 
			for (int year = date1.year; year < date2.year+1; year++) 
			{ 
				numLeapYearsInDateRange += daysInMonthService.isLeapYear(year) ? 1 : 0; 
			} 
			
			// Get the total number of days across the beginning and end years,
			// representing the total upper bound of days between date1 and date2,
			// inclusive of the extra days in the leap years in the range
			days = 365 * (date2.year - date1.year + 1) + numLeapYearsInDateRange; 
				
			// Subtract the number of days into the year for the beginning date
			days -= getNumDaysIntoYear(date1); 
	
			// Subtract the number of days from date2 until the end of that year
			days -= getDaysInYear(date2.year) - getNumDaysIntoYear(date2);  
		}
		return days;
	}
	
	// Checks that the two dates are not equal and that date2 is greater than date1
	private boolean isDateRangeValid(DateModel date1, DateModel date2)
	{
		return !date1.equals(date2) && date2.isGreaterThan(date1);
	}
	
	// Returns the number of days in the year used as input since 1 January
	int getNumDaysIntoYear(DateModel date){ 
		int numDaysIntoYear = date.day; 
		for (int month = 1; month < date.month; month++){ 
			numDaysIntoYear += daysInMonthService.getDaysInMonth(month, date.year);
		} 
		return numDaysIntoYear; 
	} 
	
	// Returns the number of days in a given year
	private int getDaysInYear(int year)
	{
		return 365 + (daysInMonthService.isLeapYear(year) ? 1 : 0);
	}
}
