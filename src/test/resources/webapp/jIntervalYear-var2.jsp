<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="ta" uri="https://github.com/dernasherbrezon/jtimeago" %>
<%
	pageContext.setAttribute("year", null);
%>
<ta:formatYear value="${year}" var="outputYear"/>
${outputYear}