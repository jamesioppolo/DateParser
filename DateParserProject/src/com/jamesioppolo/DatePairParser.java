package com.jamesioppolo;

public class DatePairParser {
	
	private DateParser dateParser;
	
	public DatePairParser(DateParser dateParser)
	{
		this.dateParser = dateParser;
	}
	
	public DatePairResultModel parse(String lineInput)
	{
		DatePairResultModel result = new DatePairResultModel();
		result.isValid = false;
		
		String[] dates = lineInput.split(", ");
		if (dates.length == 2)
		{
			DateParserResultModel dateResult1 = dateParser.parse(dates[0]);
			DateParserResultModel dateResult2 = dateParser.parse(dates[1]);
			
			if (dateResult1.isValid && dateResult2.isValid)
			{
				result.isValid = true;
				result.date1 = dateResult1.date;
				result.date2 = dateResult2.date;
			}
		}
		
		return result;
	}
}
