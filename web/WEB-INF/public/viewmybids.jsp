<%-- 
    Document   : viewmybids
    Created on : 25 Oct 2012, 11:52:57 PM
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
                                    <li id="active"><a rel=external href="viewproduct.html?id=${product.prodid}"><c:out value="Description: ${product.proddesc} Status: ${product.prodstatus}"/></a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </header>
                    <section>
                        <p>
                        <h2>Need help?</h2>
                        <p><table border="3" width="3" cellspacing="3" cellpadding="3">
                            <thead>
                                <tr>
                                    <th>Bid status 0</th>
                                    <th>Bid status 1</th>
                                    <th>Bid status 2</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Declined</td>
                                    <td>Accepted</td>
                                    <td>Pending</td>
                                </tr>
                            </tbody>
                        </table>
                        </p>
                    </section>
                </article>

                <aside>
                    <h3>View your bids</h3>
                    <p>This is a list of all the bids you have placed. The status of the bid shows you if it has been accepted or not.</p>
                </aside>

            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
