<%-- 
    Document   : login
    Created on : Oct 8, 2012, 2:23:53 AM
    Author     : Naux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <center>
            <form action="j_spring_security_check" method="POST">
                <label for="j_username">Email: </label>
                <input type="text" name="j_username" id="j_username" />
                <br />
                <label for="j_password">Password: </label>
                <input type="password" name="j_password" id="j_password" />
                <br />
                <input type="checkbox" name="spring_security_remember_me" /> Remember me
                <br />
                <input type="submit" value="Login" />
            </form>
        </center>
    </body>
</html>
