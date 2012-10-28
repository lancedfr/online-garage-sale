<%-- 
    Document   : about
    Created on : 14 Oct 2012, 6:24:26 PM
    Author     : Lance
--%>

<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ajax" uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>About Us</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link type="image/ico" rel="icon" href="<c:url value="/resources/favicon/favicon.ico" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/main.css" />" />

    <style>
        body {
            padding-top: 100px;
            padding-bottom: 40px;
        }
    </style>

</head>
<body>
    <%@include file="mainnavbar.jsp" %>
    <div class="container">

        <div class="hero-unit">
            <h1>About Us</h1>
            <p>This website will allow users to sell or buy products online in a garage sale fashion. Bidding will be incorporated into the website as a way of selling goods. Users may monitor the bids placed as well as items being sold. The system will also allow users to create a flyer to hand out to local friends and family. </p>
            <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
        </div>
        <%@include file="highlightview.jsp" %>
        <hr>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>