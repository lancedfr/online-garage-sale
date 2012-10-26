<%-- 
    Document   : acceptbid
    Created on : 25 Oct 2012, 11:54:11 PM
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
                                <c:forEach items="${products}" var="product">
                                    <li id="active">
                                        <a rel=external href="viewproduct.html?id=${product.prodid}">
                                            <c:out value="Description: ${product.proddesc} Bidding Price: ${product.prodprice}"/>
                                        </a>
                                        <c:forEach items="${product.bidList}" var="bid">
                                            <a href=processacceptbid.html?id=${bid.bidid}>
                                                <c:out value="Accept bid for: ${bid.bidamount}"/>
                                            </a>
                                        </c:forEach>
                                        <br>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </header>
                    <section>
                        <h2>article section h2</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sodales urna non odio egestas tempor. Nunc vel vehicula ante. Etiam bibendum iaculis libero, eget molestie nisl pharetra in. In semper consequat est, eu porta velit mollis nec. Curabitur posuere enim eget turpis feugiat tempor. Etiam ullamcorper lorem dapibus velit suscipit ultrices. Proin in est sed erat facilisis pharetra.</p>
                    </section>
                    <section>
                        <h2>article section h2</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sodales urna non odio egestas tempor. Nunc vel vehicula ante. Etiam bibendum iaculis libero, eget molestie nisl pharetra in. In semper consequat est, eu porta velit mollis nec. Curabitur posuere enim eget turpis feugiat tempor. Etiam ullamcorper lorem dapibus velit suscipit ultrices. Proin in est sed erat facilisis pharetra.</p>
                    </section>
                    <footer>
                        <h3>article footer h3</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sodales urna non odio egestas tempor. Nunc vel vehicula ante. Etiam bibendum iaculis libero, eget molestie nisl pharetra in. In semper consequat est, eu porta velit mollis nec. Curabitur posuere enim eget turpis feugiat tempor.</p>
                    </footer>
                </article>

                <aside>
                    <h3>aside</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sodales urna non odio egestas tempor. Nunc vel vehicula ante. Etiam bibendum iaculis libero, eget molestie nisl pharetra in. In semper consequat est, eu porta velit mollis nec. Curabitur posuere enim eget turpis feugiat tempor. Etiam ullamcorper lorem dapibus velit suscipit ultrices.</p>
                </aside>
            </div> 
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>