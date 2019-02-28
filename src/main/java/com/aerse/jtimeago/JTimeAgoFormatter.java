package com.aerse.jtimeago;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class JTimeAgoFormatter {

	public static String format(Date value, String pattern, Locale locale, TimeZone tz) {
		String formatted;
		if (locale.getLanguage().equalsIgnoreCase("ru")) {
			formatted = formatRuLocale(value, pattern, tz, locale);
		} else if (locale.getLanguage().equalsIgnoreCase("en")) {
			formatted = formatEnLocale(value, pattern, tz, locale);
		} else {
			formatted = formatUsingPattern(value, pattern, tz, locale);
		}
		return formatted;
	}

	private static String formatEnLocale(Date value, String pattern, TimeZone tz, Locale locale) {
		String formatted;
		long time = System.currentTimeMillis() - value.getTime();
		int day = (int) (time / (1000 * 60 * 60 * 24));
		int hour = (int) (time / (1000 * 60 * 60));
		int minute = (int) (time / (1000 * 60));

		if (day == 0) {
			if (hour > 0) {
				if (hour > 1) {
					formatted = hour + " hours ago";
				} else {
					formatted = hour + " hour ago";
				}
			} else {
				if (minute > 0) {
					if (minute > 1) {
						formatted = minute + " minutes ago";
					} else {
						formatted = minute + " minute ago";
					}
				} else {
					formatted = "Just now";
				}
			}
		} else {
			formatted = formatUsingPattern(value, pattern, tz, locale);
		}

		return formatted;
	}

	private static String formatRuLocale(Date value, String pattern, TimeZone tz, Locale locale) {
		String formatted;
		long time = System.currentTimeMillis() - value.getTime();
		int day = (int) (time / (1000 * 60 * 60 * 24));
		int hour = (int) (time / (1000 * 60 * 60));
		int minute = (int) (time / (1000 * 60));

		if (day == 0) {
			if (hour > 0) {
				if (hour == 1) {
					formatted = "Час назад";
				} else if (hour == 21) {
					formatted = hour + " час назад";
				} else if ((hour >= 2 && hour <= 4) || (hour >= 22 && hour <= 24)) {
					formatted = hour + " часа назад";
				} else {
					formatted = hour + " часов назад";
				}
			} else {
				if (minute > 0) {
					if (minute == 1) {
						formatted = "Минуту назад";
					} else {
						int remainer = minute % 10;
						if (remainer == 1 && minute >= 21) {
							formatted = minute + " минуту назад";
						} else if (remainer >= 2 && remainer <= 4) {
							formatted = minute + " минуты назад";
						} else {
							formatted = minute + " минут назад";
						}
					}
				} else {
					formatted = "Только что";
				}
			}
		} else {
			formatted = formatUsingPattern(value, pattern, tz, locale);
		}
		return formatted;
	}

	private static String formatUsingPattern(Date value, String pattern, TimeZone tz, Locale locale) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		if (tz != null) {
			sdf.setTimeZone(tz);
		}
		return sdf.format(value);
	}
	
	private JTimeAgoFormatter() {
		//do nothing
	}
}
