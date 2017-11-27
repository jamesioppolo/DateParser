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
	
	// Determines the number of days between the two dates as input using 
	// a 'crawling' routine that iterates through all the days until the end date
	// date1 has to be less than date2
	public int getDifferenceInDaysBetween(DateModel date1, DateModel date2)
	{
		int numDays = 0;
		
		if (isDateRangeValid(date1, date2))
		{
			DateModel crawlingDate = new DateModel(date1.day, date1.month, date1.year);
			do
			{
				numDays++;
				crawlingDate = incrementSingleDay(crawlingDate);
			} while (!crawlingDate.equals(date2));
		}
		return numDays;
	}
	
	// Checks that the two dates are not equal and that date2 is greater than date1
	private boolean isDateRangeValid(DateModel date1, DateModel date2)
	{
		return !date1.equals(date2) && date2.isGreaterThan(date1);
	}
		
	// increments the date used as input by a single day
	private DateModel incrementSingleDay(DateModel crawlingDate)
	{
		if (hasReachedEndOfMonth(crawlingDate))
		{
			crawlingDate.day = 1;
			if (crawlingDate.month < 12)
			{
				crawlingDate.month++;
			}
			else
			{	
				crawlingDate.month = 1;
				crawlingDate.year++;
			}
		}
		else
		{
			crawlingDate.day++;
		}
		return crawlingDate;
	}
	
	// returns true if the given date is at the end of the month
	private boolean hasReachedEndOfMonth(DateModel date)
	{
		return date.day == daysInMonthService.getDaysInMonth(date.month, date.year);
	}
}
