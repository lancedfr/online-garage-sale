<%-- 
    Document   : editsample
    Created on : 08 Sep 2012, 3:07:36 PM
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
        <h1>Edit sample</h1>
        <f:form action="mergesample.html" method="POST" modelAttribute="sampleBean">
            Enter the old sample id :    <f:input path="id"/><br>
            Enter a new sample student number :    <f:input path="studentNumber"/><br>
            <input type="submit" value="Submit" />
        </f:form>
    </body>
</html>
