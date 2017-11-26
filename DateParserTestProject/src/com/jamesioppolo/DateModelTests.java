package com.jamesioppolo;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateModelTests {
	@Test
	public void testEquality()
	{
		// arrange
		DateModel date1 = new DateModel(1, 1, 2000);
		DateModel date2 = new DateModel(1, 1, 2000);
		
		// act and assert
		assertTrue(date1.equals(date2));
	}
	
	@Test
	public void testInequality()
	{
		// arrange
		DateModel date1 = new DateModel(1, 1, 2001);
		DateModel date2 = new DateModel(1, 1, 2000);
		
		// act and assert
		assertFalse(date1.equals(date2));
	}
	
	@Test
	public void testGreaterThan()
	{
		// arrange
		DateModel date1 = new DateModel(1, 1, 2009);
		DateModel date2 = new DateModel(1, 1, 2010);
		
		// act and assert
		assertTrue(date2.isGreaterThan(date1));
	}
}
