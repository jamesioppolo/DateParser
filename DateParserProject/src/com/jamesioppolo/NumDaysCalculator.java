package com.jamesioppolo;

public class NumDaysCalculator {
	
	private DaysInMonthService daysInMonthService;
	
	public NumDaysCalculator(DaysInMonthService daysInMonthService)
	{
		this.daysInMonthService = daysInMonthService;
	}
	
	public int getDifferenceInDaysBetween(DateModel date1, DateModel date2)
	{
		int numDays = 0;
		DateModel crawlingDate = date1;
		
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
