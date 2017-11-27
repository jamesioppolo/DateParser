package com.jamesioppolo;

public class DatePairResultModel {
	public boolean isValid;
	public DateModel date1;
	public DateModel date2;
	
	public String getOrderedDateString()
	{
		return String.format("%02d %02d %4d, %02d %02d %4d", 
				date1.day, date1.month, date1.year,
				date2.day, date2.month, date2.year);
	}
}
