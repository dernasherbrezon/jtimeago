package com.aerse.jtimeago;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public abstract class AbstractJInterval extends TagSupport {

	private static final long serialVersionUID = 2082251387328125388L;

	private Number value;
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
		String formatted = format(value.intValue(), locale);

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

	public abstract String format(int value, Locale locale);

	public void setValue(Number value) {
		this.value = value;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setScope(String scope) {
		this.scope = Util.convert(scope);
	}
	
	private int getScope() {
		if( this.scope == 0 ) {
			return PageContext.PAGE_SCOPE;
		}
		return this.scope;
	}

}
