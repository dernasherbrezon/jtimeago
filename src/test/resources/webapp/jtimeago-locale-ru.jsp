<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="ta" uri="https://github.com/dernasherbrezon/jtimeago" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	java.util.Date comment = new java.util.Date(1534320716000L);
	pageContext.setAttribute("comment", comment);
%>
<fmt:setLocale value="ru"/>
<ta:formatDate value="${comment}" pattern="dd MMMM yyyy HH:mm" />