package com.aerse.jtimeago;

import javax.servlet.jsp.PageContext;

class Util {

	static int convert(String scope) {
		if ("request".equalsIgnoreCase(scope)) {
			return PageContext.REQUEST_SCOPE;
		} else if ("session".equalsIgnoreCase(scope)) {
			return PageContext.SESSION_SCOPE;
		} else if ("application".equalsIgnoreCase(scope)) {
			return PageContext.APPLICATION_SCOPE;
		} else {
			throw new IllegalArgumentException("unsupported scope: " + scope);
		}
	}

	private Util() {
		// do nothing
	}

}
