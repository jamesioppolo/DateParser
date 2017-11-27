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
	public int getDifferenceInDaysBetween(DateModel date1, DateModel date2)
	{
		int numDays = 0;
		DateModel crawlingDate = new DateModel(date1.day, date1.month, date1.year);
		
		if (crawlingDate.equals(date2))
		{
			return numDays;
		}
		
		do
		{
			numDays++;
			if (crawlingDate.day == daysInMonthService.getDaysInMonth(crawlingDate.month, crawlingDate.year))
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
			
			
		} while (!crawlingDate.equals(date2));
			
		return numDays;
	}
}
