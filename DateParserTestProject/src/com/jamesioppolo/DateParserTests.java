package com.jamesioppolo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DateParserTests {

	private DateParser dateParser;
	
	@Before
	public void setup()
	{
		dateParser = new DateParser(new DaysInMonthService());
	}
	
	@Test
	public void testFirstJanTwoThousand() {
		// act
		DateParserResultModel result = dateParser.parse("01 01 2000");
		
		// assert
		assertTrue(result.isValid);
		assertEquals(result.date.day, 1);
		assertEquals(result.date.month, 1);
		assertEquals(result.date.year, 2000);
	}
	
	@Test
	public void testEleventhDecTwoThousandNine() {
		// act
		DateParserResultModel result = dateParser.parse("11 12 2009");
		
		// assert
		assertTrue(result.isValid);
		assertEquals(result.date.day, 11);
		assertEquals(result.date.month, 12);
		assertEquals(result.date.year, 2009);
	}
	
	@Test
	public void testThirtiethFebruary() {
		// act
		DateParserResultModel result = dateParser.parse("30 02 2000");
		
		// assert
		assertFalse(result.isValid);
	}
	
	@Test
	public void testFirstJanTwoThousand_WithAnExtraNumber() {
		// arrange and act
		DateParserResultModel result = dateParser.parse("01 01 20002");
		
		// assert
		assertFalse(result.isValid);
	}

	@Test
	public void testFirstJanTwoThousand_WithNoSpaces() {
		// arrange and act
		DateParserResultModel result = dateParser.parse("010120002");
		
		// assert
		assertFalse(result.isValid);
	}
}
