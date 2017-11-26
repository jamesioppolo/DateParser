package com.jamesioppolo;

public class DatePairParser {
	
	private DateParser dateParser;
	
	public DatePairParser(DateParser dateParser)
	{
		this.dateParser = dateParser;
	}
	
	// Parses the two dates used as input of form "DD MM YYYY, DD MM YYYY".
	// WIll return result set with the earliest date first
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
				if (dateResult2.date.isGreaterThan(dateResult1.date))
				{
					result.date1 = dateResult1.date;
					result.date2 = dateResult2.date;
				}
				else
				{
					result.date1 = dateResult2.date;
					result.date2 = dateResult1.date;
				}
			}
		}
		
		return result;
	}
}
