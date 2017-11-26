package com.jamesioppolo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumDaysCalculatorTests {

	private NumDaysCalculator numDaysCalculator;
	
	@Before
	public void setup()
	{
		numDaysCalculator = new NumDaysCalculator(new DaysInMonthService());
	}

	@Test
	public void OnSameDay() {
		// arrange and act
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 1999),
			new DateModel(1, 1, 1999));
		
		// assert
		assertTrue(numDays == 0);
	}

	@Test
	public void OnSameDay_OneMonthApart() {
		// arrange and act
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 1999),
			new DateModel(1, 2, 1999));
		
		// assert
		assertTrue(numDays == 31);
	}
	
	@Test
	public void OneDayApart() {
		// arrange and act
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 1999),
			new DateModel(2, 1, 1999));
		
		// assert
		assertTrue(numDays == 1);
	}
	
	@Test
	public void SameDatesOneYearApart() {
		// arrange and act
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 1999),
			new DateModel(1, 1, 2000));
		
		// assert
		assertTrue(numDays == 365);
	}
	
	@Test
	public void SameDatesOneYearApart_OverLeapYear() {
		// arrange and act
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 2000),
			new DateModel(1, 1, 2001));
		
		// assert
		assertTrue(numDays == 366);
	}
	
	@Test
	public void longRangeTest() {
		// arrange and act
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 2000),
			new DateModel(2, 2, 2009));
		
		// assert
		assertTrue(numDays == 3320);
	}
	
	@Test
	// Example taken from 
	// https://www.timeanddate.com/date/durationresult.html?d1=3&m1=4&y1=1905&d2=5&m2=7&y2=2006
	public void extraLongRangeTest() {
		// arrange and act
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(3, 4, 1905),
			new DateModel(5, 7, 2006));
		
		// assert
		assertTrue(numDays == 36983);
	}
	
}
