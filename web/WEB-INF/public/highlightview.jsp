<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : highlightview
    Created on : 28 Oct 2012, 1:43:10 PM
    Author     : Lance
--%>

<div class="row">
    <div class="span4">
        <h2>Hot Product</h2>
        <p>Our best pick</p>
        <p><img src="./resources/img/bestpick.jpg" width="500" height="300" alt="bestpick"/></p>
        <p><a class="btn" href="#">View details &raquo;</a></p>
    </div>
    <div class="span4">
        <h2>Top Bidding</h2>
        <p>Our top bidding</p>
        <p><img src="./resources/img/topbidding.jpg" width="500" height="300" alt="bestpick"/></p>
        <p><a class="btn" href="#">View details &raquo;</a></p>
    </div>
    <div class="span4">
        <h2>Top Bidder</h2>
        <p>Our top bidder is: </p>
        <table border="1" cellspacing="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Last name</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Ashwyn</td>
                    <td>Coert</td>
                </tr>
            </tbody>
        </table>

    </div>
</div>
