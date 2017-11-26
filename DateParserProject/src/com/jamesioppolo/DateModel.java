package com.jamesioppolo;

public class DateModel {
	public int day;
	public int month;
	public int year;
	
	public DateModel(Integer day, Integer month, Integer year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Boolean equals(DateModel date)
	{
		return this.day == date.day && 
			this.month == date.month &&
			this.year == date.year;
	}
}
