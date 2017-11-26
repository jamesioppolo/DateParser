package com.jamesioppolo;

public class DateParser {
	
	public DateParserResultModel parse(String dateString)
	{
		DateParserResultModel result = new DateParserResultModel();
		result.isValid = false;
		
		if (isDateStringValid(dateString))
		{
			String[] dateElements = dateString.split("[ ]");
			
			Integer day = Integer.parseInt(dateElements[0]);
			Integer month = Integer.parseInt(dateElements[1]);
			Integer year = Integer.parseInt(dateElements[2]);
			
			if (isDayValid(day) && isMonthValid(month) && isYearValid(year))
			{
				result.isValid = true;
				result.date.day = day;
				result.date.month = month;
				result.date.year = year;
			}
		}
		
		return result;
	}
	
	public Boolean isDateStringValid(String dateString)
	{
		return dateString.matches("\\d{2} \\d{2} \\d{4}");
	}
	
	public Boolean isDayValid(Integer day)
	{
		return day >= 1 && day <= 31;
	}
	
	public Boolean isMonthValid(Integer month)
	{
		return month >= 1 && month <= 12;
	}
	
	public Boolean isYearValid(Integer year)
	{
		return year >= 1900 && year <= 2010;
	}
}
