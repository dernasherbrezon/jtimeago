package com.aerse.jtimeago;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

public class JIntervalFormatterTest {

	private final static Locale RUSSIAN = Locale.forLanguageTag("ru");

	@Test
	public void testEnglishMonth() {
		assertEquals("1 month", JIntervalFormatter.formatMonth(1, Locale.ENGLISH));
		assertEquals("2 months", JIntervalFormatter.formatMonth(2, Locale.ENGLISH));
	}
	
	@Test
	public void testRussianMonth() {
		assertEquals("1 месяц", JIntervalFormatter.formatMonth(1, RUSSIAN));
		assertEquals("2 месяца", JIntervalFormatter.formatMonth(2, RUSSIAN));
		assertEquals("5 месяцев", JIntervalFormatter.formatMonth(5, RUSSIAN));
		assertEquals("6 месяцев", JIntervalFormatter.formatMonth(6, RUSSIAN));
		assertEquals("11 месяцев", JIntervalFormatter.formatMonth(11, RUSSIAN));
		assertEquals("21 месяц", JIntervalFormatter.formatMonth(21, RUSSIAN));
		assertEquals("22 месяца", JIntervalFormatter.formatMonth(22, RUSSIAN));
		assertEquals("25 месяцев", JIntervalFormatter.formatMonth(25, RUSSIAN));
	}
	
	@Test
	public void testEnglishYear() {
		assertEquals("1 year", JIntervalFormatter.formatYear(1, Locale.ENGLISH));
		assertEquals("2 years", JIntervalFormatter.formatYear(2, Locale.ENGLISH));
		assertEquals("11 years", JIntervalFormatter.formatYear(11, Locale.ENGLISH));
		assertEquals("21 year", JIntervalFormatter.formatYear(21, Locale.ENGLISH));
	}
	
	@Test
	public void testRussianYear() {
		assertEquals("1 год", JIntervalFormatter.formatYear(1, RUSSIAN));
		assertEquals("2 года", JIntervalFormatter.formatYear(2, RUSSIAN));
		assertEquals("5 лет", JIntervalFormatter.formatYear(5, RUSSIAN));
		assertEquals("6 лет", JIntervalFormatter.formatYear(6, RUSSIAN));
		assertEquals("11 лет", JIntervalFormatter.formatYear(11, RUSSIAN));
		assertEquals("21 год", JIntervalFormatter.formatYear(21, RUSSIAN));
		assertEquals("22 года", JIntervalFormatter.formatYear(22, RUSSIAN));
		assertEquals("25 лет", JIntervalFormatter.formatYear(25, RUSSIAN));
	}
	
}
