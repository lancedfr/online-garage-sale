<%-- 
    Document   : mygarage
    Created on : 19 Oct 2012, 12:34:58 AM
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
                                <c:forEach items="${userProducts}" var="product">
                                    <li id="active"><a rel=external href="viewproduct.html?id=${product.prodid}"><c:out value="Description: ${product.proddesc}"/></a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </header>
                    <section>
                        <h2>Need help?</h2>
                        <p>Feel free to <a href="#">ask</a> us a question or drop a <a href="#">comment</a>.</p>
                    </section>
                </article>

                <aside>
                    <h3>Welcome to your garage</h3>
                    <p>This is your garage. From here you can add, edit or search for products. The list to the left shows you all the products in your garage, if there is no list start by <a href="addproduct.html">adding a product</a></p>
                </aside>
            </div> 
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

