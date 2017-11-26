package com.jamesioppolo;

public class DateParserResultModel {
	public Boolean isValid;
	public DateModel date;
	
	public DateParserResultModel()
	{
		date = new DateModel(0, 0, 0);
	}
}
