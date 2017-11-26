package com.jamesioppolo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumDaysCalculatorTests {

	private NumDaysCalculator numDaysCalculator;
	
	@Before
	public void setup()
	{
		numDaysCalculator = new NumDaysCalculator();
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
	
}
