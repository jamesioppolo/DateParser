package com.jamesioppolo;

public class DaysInMonthService {
	public int getDaysInMonth(int month, int year)
	{
		switch(month)
		{
			case 1: return 31;
			case 2: return getNumberOfDaysInFebruaryFor(year);
			case 3: return 31;
			case 4: return 30;
			case 5: return 31;
			case 6: return 30;
			case 7: return 31;
			case 8: return 31;
			case 9: return 30;
			case 10: return 31;
			case 11: return 30;
			case 12: return 31;
		}
		return 0;
	}
	
	private Integer getNumberOfDaysInFebruaryFor(int year)
	{
		return isLeapYear(year) ? 29 : 28;
	}
	
	private Boolean isLeapYear(Integer year)
	{
		if (year % 4 != 0) {
			return false;
		} else if (year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
		} else {
			return true;
		}
	}
}
