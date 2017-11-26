package com.jamesioppolo;

public class DateModel {
	public int day;
	public int month;
	public int year;
	
	public DateModel(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	// Equality test requires equality of all components to represent equality 
	public boolean equals(DateModel date)
	{
		return this.day == date.day && 
			this.month == date.month &&
			this.year == date.year;
	}
	
	// Simple test to determine if date used as input is greater than this date
	// creates a single integer YYYYMMDD and uses standard integer greater than 
	// operator.
	public boolean isGreaterThan(DateModel otherDate)
	{
		int thisDateInteger = Integer.parseInt(String.format("%4d%02d%02d", year, month, day));	
		int otherDateInteger = Integer.parseInt(String.format("%4d%02d%02d", otherDate.year, otherDate.month, otherDate.day));
		return thisDateInteger > otherDateInteger;
	}
}
