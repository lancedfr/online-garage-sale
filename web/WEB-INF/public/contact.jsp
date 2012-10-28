<%-- 
    Document   : contact
    Created on : 17 Oct 2012, 7:24:19 PM
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
    <title>Contact Us</title>
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
            <h1>Contact Us</h1>
            <br>
            <p>For info Contact:</p>
            <p>Devon Richards -> DevonR@Info.co.za</p>
            <p>For maintenance contact:</p>
            <p>Lance Reid -> LanceR@Maintenance.co.za</p>
            <p>For Problems or issues Contact:</p>
            <p>Dwayne Peterson -> DwayneP@Error.co.za</p>
            <br>
            <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
        </div>

        <div class="row">
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="#">View details &raquo;</a></p>
            </div>
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="#">View details &raquo;</a></p>
            </div>
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                <p><a class="btn" href="#">View details &raquo;</a></p>
            </div>
        </div>
        <hr>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>