package com.jamesioppolo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DateParserTests {

	private DateParser dateParser;
	
	@Before
	public void setup()
	{
		dateParser = new DateParser();
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
	public void testFirstJanTwoThousand_WithAnExtraNumber() {
		DateParserResultModel result = dateParser.parse("01 01 20002");
		assertFalse(result.isValid);
	}

	@Test
	public void testFirstJanTwoThousand_WithNoSpaces() {
		DateParserResultModel result = dateParser.parse("010120002");
		assertFalse(result.isValid);
	}
}
