package com.jamesioppolo;

public class DateParser {
	
	private DaysInMonthService daysInMonthService;
	
	public DateParser(DaysInMonthService daysInMonthService)
	{
		this.daysInMonthService = daysInMonthService;
	}
	
	public DateParserResultModel parse(String dateString)
	{
		DateParserResultModel result = new DateParserResultModel();
		result.isValid = false;
		
		if (isDateStringValid(dateString))
		{
			DateModel date = getDateFrom(dateString);
			
			if (isDayValid(date) && isMonthValid(date) && isYearValid(date))
			{
				result.isValid = true;
				result.date = date;
			}
		}
		
		return result;
	}
	
	private DateModel getDateFrom(String dateString)
	{
		String[] dateElements = dateString.split("[ ]");
		
		return new DateModel(
			Integer.parseInt(dateElements[0]),
			Integer.parseInt(dateElements[1]),
			Integer.parseInt(dateElements[2]));
	}
	
	private boolean isDateStringValid(String dateString)
	{
		return dateString.matches("\\d{2} \\d{2} \\d{4}");
	}
	
	private boolean isDayValid(DateModel date)
	{
		return date.day >= 1 && date.day <= daysInMonthService.getDaysInMonth(date.month, date.year);
	}
	
	private boolean isMonthValid(DateModel date)
	{
		return date.month >= 1 && date.month <= 12;
	}
	
	private boolean isYearValid(DateModel date)
	{
		return date.year >= 1900 && date.year <= 2010;
	}
}
