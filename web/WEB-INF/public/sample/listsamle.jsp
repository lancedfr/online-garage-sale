<%-- 
    Document   : listsamle
    Created on : 08 Sep 2012, 3:07:51 PM
    Author     : Lance
--%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List sample</h1>
        <f:form action="list.html" method="GET">
            <c:forEach var="obj" items="${samples}">
                <c:out value="${obj.id}"></c:out></br>
            </c:forEach>
        </f:form>
    </body>
</html>
