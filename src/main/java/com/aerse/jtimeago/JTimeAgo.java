package com.aerse.jtimeago;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class JTimeAgo extends TagSupport {

	private static final long serialVersionUID = -3339675287660756902L;

	private Date value;
	private String pattern;
	private TimeZone timeZone;
	private String var;
	private int scope;

	@Override
	public int doEndTag() throws JspException {
		if (value == null) {
			if (var != null) {
				pageContext.removeAttribute(var, getScope());
			}
			return EVAL_PAGE;
		}

		Locale locale = pageContext.getResponse().getLocale();
		String formatted = JTimeAgoFormatter.format(value, pattern, locale, timeZone);

		if (var != null) {
			pageContext.setAttribute(var, formatted, getScope());
		} else {
			try {
				pageContext.getOut().print(formatted);
			} catch (IOException ioe) {
				throw new JspTagException(ioe.toString(), ioe);
			}
		}

		return EVAL_PAGE;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setTimeZone(Object timeZone) {
		if (timeZone == null) {
			return;
		}
		if (timeZone instanceof String) {
			this.timeZone = TimeZone.getTimeZone((String) timeZone);
		} else if (timeZone instanceof TimeZone) {
			this.timeZone = (TimeZone) timeZone;
		} else {
			throw new IllegalArgumentException("bad timezone: " + timeZone);
		}
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setScope(String scope) {
		this.scope = Util.convert(scope);
	}

	private int getScope() {
		if (this.scope == 0) {
			return PageContext.PAGE_SCOPE;
		}
		return this.scope;
	}

}
