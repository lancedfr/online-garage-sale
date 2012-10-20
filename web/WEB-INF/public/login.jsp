<%-- 
    Document   : login
    Created on : Oct 8, 2012, 2:23:53 AM
    Author     : Naux
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ajax" uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"%>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Sign Up</title>
        <link type="image/ico" rel="icon" href="<c:url value="/resources/favicon/favicon.ico" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/main.css" />" />
        <link href="<c:url value="/resources/signup/css/style.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/signup/css/uniform.css" />" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/signup/js/jquery.tools.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/signup/js/jquery.uniform.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/signup/js/main.js"/>"></script>

        <style>
            body {
                padding-top: 100px;
                padding-bottom: 40px;
            }
            input{
                width: 25%;
            }
        </style>

    </head>
    <body>
        <%@include file="mainnavbar.jsp" %>
        <div class="container">
            <h2>Login</h2>
            <form action="j_spring_security_check" method="POST">
                <label for="j_username">Email: </label>
                <input type="text" name="j_username" id="j_username" />
                <br />
                <label for="j_password">Password: </label>
                <input type="password" name="j_password" id="j_password" />
                <br />
                <input type="checkbox" name="spring_security_remember_me" /> Remember me
                <br />
                <button type="submit" class="btn">Log in</button>
                <a href="signup.html">
                    <button type="button" class="btn">Sign up</button>
                </a>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>