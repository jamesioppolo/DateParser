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
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 1999),
			new DateModel(1, 1, 1999));
		assertTrue(numDays == 0);
	}

	@Test
	public void OnSameDay_OneMonthApart() {
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 1999),
			new DateModel(1, 2, 1999));
		assertTrue(numDays == 31);
	}
	
	@Test
	public void OneDayApart() {
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 1999),
			new DateModel(2, 1, 1999));
		assertTrue(numDays == 1);
	}
	
	@Test
	public void SameDatesOneYearApart() {
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 1999),
			new DateModel(1, 1, 2000));
		assertTrue(numDays == 365);
	}
	
	@Test
	public void SameDatesOneYearApart_OverLeapYear() {
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 2000),
			new DateModel(1, 1, 2001));
		assertTrue(numDays == 366);
	}
	
	@Test
	public void longRangeTest() {
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(1, 1, 2000),
			new DateModel(2, 2, 2009));
		assertTrue(numDays == 3320);
	}
	
	@Test
	public void extraLongRangeTest() {
		Integer numDays = numDaysCalculator.getDifferenceInDaysBetween(
			new DateModel(3, 4, 1905),
			new DateModel(5, 7, 2006));
		assertTrue(numDays == 36983);
	}
	
}
