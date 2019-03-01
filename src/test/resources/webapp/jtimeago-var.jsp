<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="ta" uri="https://github.com/dernasherbrezon/jtimeago" %>
<%
	java.util.Date comment = new java.util.Date(1534320716000L);
	pageContext.setAttribute("comment", comment);
%>
<ta:formatDate value="${comment}" var="outputCommentDate" pattern="dd MMM yyyy HH:mm" />
${outputCommentDate}