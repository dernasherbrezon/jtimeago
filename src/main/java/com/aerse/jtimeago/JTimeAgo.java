package com.aerse.jtimeago;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class JTimeAgo extends TagSupport {

	private static final long serialVersionUID = -3339675287660756902L;

	private Date value;
	private String pattern;
	private Object timeZone;
	private String var;
	private int scope;

	@Override
	public int doEndTag() throws JspException {
		if (value == null) {
			if (var != null) {
				pageContext.removeAttribute(var, scope);
			}
			return EVAL_PAGE;
		}

		TimeZone tz = null;
		if ((timeZone instanceof String) && ((String) timeZone).equals("")) {
			timeZone = null;
		}
		if (timeZone != null) {
			if (timeZone instanceof String) {
				tz = TimeZone.getTimeZone((String) timeZone);
			} else if (timeZone instanceof TimeZone) {
				tz = (TimeZone) timeZone;
			} else {
				throw new JspTagException("bad timezone: " + timeZone);
			}
		}

		Locale locale = Locale.getDefault();
		String formatted = JTimeAgoFormatter.format(value, pattern, locale, tz);

		if (var != null) {
			pageContext.setAttribute(var, formatted, scope);
		} else {
			try {
				pageContext.getOut().print(formatted);
			} catch (IOException ioe) {
				throw new JspTagException(ioe.toString(), ioe);
			}
		}

		return EVAL_PAGE;
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Object getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Object timeZone) {
		this.timeZone = timeZone;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

}
