<%-- 
    Document   : viewproduct
    Created on : 20 Oct 2012, 12:04:07 PM
    Author     : Lance
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ajax" uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"%>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>My Garage</title>
        <link type="image/ico" rel="icon" href="<c:url value="/resources/favicon/favicon.ico" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/mygarage/css/normalize.min.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/mygarage/css/main.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/listcss.css" />" />
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>        
        <%@include file="mygaragenavbar.jsp" %>

        <div class="main-container">
            <div class="main wrapper clearfix">
                <article>
                    <header>
                        <div id="navcontainer">
                            <ul id="navlist" data-role="listview" data-theme="g">
                                <li id="active"><c:out value="Description: ${product.proddesc} ${product.prodprice}"/></a></li>
                            </ul>
                        </div>
                    </header>
                </article>
                <footer>
                    <h3>More information</h3>
                    <p>The amount next to the product is the offering price.</p>
                </footer>
                <aside>
                    <h3>View product</h3>
                    <p>Here you can view all the information about the product you selected.</p>
                </aside>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>