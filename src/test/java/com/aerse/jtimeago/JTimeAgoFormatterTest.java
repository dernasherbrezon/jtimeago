package com.aerse.jtimeago;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.junit.Test;

public class JTimeAgoFormatterTest {

	private final static Locale RUSSIAN = Locale.forLanguageTag("ru");

	@Test
	public void testUnsupportedLocale() {
		Calendar cal = Calendar.getInstance(JIntervalFormatterTest.UNSUPPORTED_LOCALE);
		String actual = JTimeAgoFormatter.format(cal.getTime(), "dd MMM yyyy HH:mm", JIntervalFormatterTest.UNSUPPORTED_LOCALE, null);
		String expected = new SimpleDateFormat("dd MMM yyyy HH:mm", JIntervalFormatterTest.UNSUPPORTED_LOCALE).format(cal.getTime());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEnglish() {
		Calendar cal = Calendar.getInstance(Locale.ENGLISH);
		assertEquals("Just now", formatEn(cal));
		cal = Calendar.getInstance(Locale.ENGLISH);
		cal.add(Calendar.MINUTE, -1);
		assertEquals("1 minute ago", formatEn(cal));
		cal = Calendar.getInstance(Locale.ENGLISH);
		cal.add(Calendar.MINUTE, -4);
		assertEquals("4 minutes ago", formatEn(cal));
		cal = Calendar.getInstance(Locale.ENGLISH);
		cal.add(Calendar.HOUR, -1);
		assertEquals("1 hour ago", formatEn(cal));
		cal = Calendar.getInstance(Locale.ENGLISH);
		cal.add(Calendar.HOUR, -2);
		assertEquals("2 hours ago", formatEn(cal));
		cal = Calendar.getInstance(Locale.ENGLISH);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		assertEquals(new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.ENGLISH).format(cal.getTime()), formatEn(cal));
	}
	
	@Test
	public void testRussian() {
		Calendar cal = Calendar.getInstance(RUSSIAN);
		assertEquals("Только что", format(cal));
		cal = Calendar.getInstance(RUSSIAN);
		cal.add(Calendar.MINUTE, -1);
		assertEquals("Минуту назад", format(cal));
		cal = Calendar.getInstance(RUSSIAN);
		cal.add(Calendar.MINUTE, -4);
		assertEquals("4 минуты назад", format(cal));
		cal = Calendar.getInstance(RUSSIAN);
		cal.add(Calendar.MINUTE, -6);
		assertEquals("6 минут назад", format(cal));
		cal = Calendar.getInstance(RUSSIAN);
		cal.add(Calendar.MINUTE, -21);
		assertEquals("21 минуту назад", format(cal));
		cal = Calendar.getInstance(RUSSIAN);
		cal.add(Calendar.HOUR, -1);
		assertEquals("Час назад", format(cal));
		cal = Calendar.getInstance(RUSSIAN);
		cal.add(Calendar.HOUR, -2);
		assertEquals("2 часа назад", format(cal));
		cal = Calendar.getInstance(RUSSIAN);
		cal.add(Calendar.HOUR, -21);
		assertEquals("21 час назад", format(cal));
		cal = Calendar.getInstance(RUSSIAN);
		cal.add(Calendar.HOUR, -5);
		assertEquals("5 часов назад", format(cal));
		cal = Calendar.getInstance(RUSSIAN);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		assertEquals(new SimpleDateFormat("dd MMM yyyy HH:mm", RUSSIAN).format(cal.getTime()), format(cal));
	}
	
	private static String format(Calendar cal) {
		return JTimeAgoFormatter.format(cal.getTime(), "dd MMM yyyy HH:mm", RUSSIAN, null);
	}

	private static String formatEn(Calendar cal) {
		return JTimeAgoFormatter.format(cal.getTime(), "dd MMM yyyy HH:mm", Locale.ENGLISH, null);
	}

}
