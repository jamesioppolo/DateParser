package com.jamesioppolo;

interface IDateParser {
	DateParserResultModel parse(String dateString);
}

public class DateParser implements IDateParser {
	
	private IDaysInMonthService daysInMonthService;
	
	public DateParser(IDaysInMonthService daysInMonthService)
	{
		this.daysInMonthService = daysInMonthService;
	}
	
	// Parses a date from a string of form "DD MM YYYY" used as input
	// Uses a regex for validation. Also ensures that the actual days
	// for the given month is valid, including feburary in leap years.
	public DateParserResultModel parse(String dateString)
	{
		DateParserResultModel result = new DateParserResultModel();
		result.isValid = false;
		
		if (isDateStringValid(dateString))
		{
			DateModel date = getDateFrom(dateString);
			if (isDateValid(date))
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
	
	
	private boolean isDateValid(DateModel date)
	{
		return isDayValid(date) &&
			isMonthValid(date) &&
			isYearValid(date);
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
