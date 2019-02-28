package com.aerse.jtimeago;

import java.util.Locale;

public class JIntervalYear extends AbstractJInterval {

	private static final long serialVersionUID = -3339675287660756902L;

	@Override
	public String format(int value, Locale locale) {
		return JIntervalFormatter.formatYear(value, locale);
	}
	
}