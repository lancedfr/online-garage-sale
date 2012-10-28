<%-- 
    Document   : placebid
    Created on : 20 Oct 2012, 7:57:57 PM
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
        <style>
            .btn{
                padding:4px 10px 4px;
                font-weight:normal;
                -webkit-border-radius:4px;
                -moz-border-radius:4px;
                border-radius:4px
            }
        </style>
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
                            <f:form action="processplacebid.html?id=${product.prodid}" method="post" novalidate="" modelAttribute="product">
                                <f:input class="span2" type="text" path="prodprice" id="field6" placeholder="Bid Amount" required="required" pattern="\d+(\.\d{2})?"/>
                                <div id="form-submit" class="btn">
                                    <input value="Place Bid" type="submit">
                                </div>
                            </f:form>
                        </div>
                    </header>
                    <footer>
                        <h3>Bidding amount</h3>
                        <p>The amount next to the product is the offering price.</p>
                    </footer>
                </article>

                <aside>
                    <h3>Place a bid</h3>
                    <p>To place a bid, enter your bid amount and click place bid.</p>
                </aside>

            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>