<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="ta" uri="https://github.com/dernasherbrezon/jtimeago" %>
<%
	pageContext.setAttribute("comment", null);
%>
<ta:formatDate value="${comment}" var="outputCommentDate" pattern="dd MMM yyyy HH:mm" />
${outputCommentDate}