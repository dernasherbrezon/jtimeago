package com.aerse.jtimeago;

import java.util.Locale;

public class JIntervalFormatter {

	public static String formatMonth(int month, Locale locale) {
		if (month <= 0) {
			throw new IllegalArgumentException("month should be positive: " + month);
		}
		String formatted;
		if (locale.getLanguage().equalsIgnoreCase("ru")) {
			formatted = formatMonthRuLocale(month);
		} else if (locale.getLanguage().equalsIgnoreCase("en")) {
			formatted = formatMonthEnLocale(month);
		} else {
			throw new IllegalArgumentException("unsupported language: " + locale.getLanguage());
		}
		return formatted;
	}

	private static String formatMonthEnLocale(int month) {
		String suffix;
		if (month == 1) {
			suffix = " month";
		} else {
			suffix = " months";
		}
		return month + suffix;
	}

	private static String formatMonthRuLocale(int month) {
		int remainer = month % 10;
		String suffix;
		if (remainer == 1 && month != 11) {
			suffix = " месяц";
		} else if (remainer > 1 && remainer <= 4 && (month < 10 || month > 20)) {
			suffix = " месяца";
		} else {
			suffix = " месяцев";
		}
		return month + suffix;
	}

	public static String formatYear(int year, Locale locale) {
		if (year <= 0) {
			throw new IllegalArgumentException("year should be positive: " + year);
		}
		String formatted;
		if (locale.getLanguage().equalsIgnoreCase("ru")) {
			formatted = formatYearRuLocale(year);
		} else if (locale.getLanguage().equalsIgnoreCase("en")) {
			formatted = formatYearEnLocale(year);
		} else {
			throw new IllegalArgumentException("unsupported language: " + locale.getLanguage());
		}
		return formatted;
	}

	private static String formatYearEnLocale(int year) {
		int remainer = year % 10;
		String suffix;
		if (remainer == 1 && year != 11) {
			suffix = " year";
		} else {
			suffix = " years";
		}
		return year + suffix;
	}

	private static String formatYearRuLocale(int year) {
		int remainer = year % 10;
		String suffix;
		if (remainer == 1 && year != 11) {
			suffix = " год";
		} else if (remainer > 1 && remainer <= 4 && (year < 10 || year > 20)) {
			suffix = " года";
		} else {
			suffix = " лет";
		}
		return year + suffix;
	}
	
	private JIntervalFormatter() {
		//do nothing
	}

}
