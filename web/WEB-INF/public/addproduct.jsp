<%-- 
    Document   : addproduct
    Created on : 19 Oct 2012, 1:13:36 AM
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
        <title>Add Product</title>
        <link type="image/ico" rel="icon" href="<c:url value="/resources/favicon/favicon.ico" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/addproduct/css/normalize.min.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/addproduct/css/main.css" />" />
        <link href="css/style.css" media="screen" rel="stylesheet" type="text/css"/>

        <link href="<c:url value="/resources/addproduct/css/uniform.css" />" media="screen" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/addproduct/css/style.css" />" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>        
        <script type="text/javascript" src="<c:url value="/resources/addproduct/js/jquery.tools.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/addproduct/js/jquery.uniform.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/addproduct/js/main.js"/>"></script>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <style>
            .btn {
                padding: 4px 10px 4px;
                font-weight: normal;
                -webkit-border-radius: 4px;
                -moz-border-radius: 4px;
                border-radius: 4px;
            }
        </style>
    </head>
    <body>
        <%@include file="mygaragenavbar.jsp" %>
        <div class="main-container">
            <div class="main wrapper clearfix">
                <article>
                    <header>
                        <div class="TTWForm-container">
                            <f:form action="addproductprocess.html" method="post" novalidate="" modelAttribute="productBean">
                                <div id="field1-container" class="field f_100">
                                    <label for="field1">
                                        Product Description
                                    </label>
                                    <f:input path="proddesc" id="field1" required="required" type="text"/>
                                </div>
                                <div id="field3-container" class="field f_100">
                                    <label for="field3">
                                        Product Condition
                                    </label>
                                    <f:select path="prodcondition" id="field3" required="required">
                                        <option id="field3-1" value="">
                                        </option>
                                        <option id="field3-2" value="Poor">
                                            Poor
                                        </option>
                                        <option id="field3-3" value="Average">
                                            Average
                                        </option>
                                        <option name="prodcondition" id="prodcondition-4" value="Good">
                                            Good
                                        </option>
                                        <option name="prodcondition" id="prodcondition-5" value="New">
                                            New
                                        </option>
                                    </f:select>
                                </div>
                                <div id="field7-container" class="field f_100">
                                    <label for="field7">
                                        Product Category
                                    </label>
                                    <f:select path="categoryid" id="field7" required="required">
                                        <option id="field7-1" value="">
                                        </option>
                                        <option id="field7-2" value=" Home &amp; Garden">
                                            Home &amp; Garden
                                        </option>
                                        <option id="field7-3" value="Fashion">
                                            Fashion
                                        </option>
                                        <option name="categoryid" id="categoryid-4" value="Electronics">
                                            Electronics
                                        </option>
                                    </f:select>
                                </div>
                                <div id="field4-container" class="field f_100">
                                    <label for="field4">
                                        Product Image
                                    </label>
                                    <f:input path="prodimage" id="field4" type="file"/>
                                </div>
                                <div id="field5-container" class="field f_100">
                                    <label for="field5">
                                        Product Bid Price
                                    </label>
                                    <f:input path="prodprice" id="field5" required="required" type="text"/>
                                </div>
                                <!--<button type="submit" class="btn">Submit</button>-->
                                <div id="form-submit" class="field f_100 clearfix submit">
                                    <input type="submit" value="Submit" name="btnSubmit" path="">
                                </div>
                            </f:form>
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
                    <h3>Add product help</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sodales urna non odio egestas tempor. Nunc vel vehicula ante. Etiam bibendum iaculis libero, eget molestie nisl pharetra in. In semper consequat est, eu porta velit mollis nec. Curabitur posuere enim eget turpis feugiat tempor. Etiam ullamcorper lorem dapibus velit suscipit ultrices.</p>
                </aside>

            </div> <!-- #main -->
        </div> <!-- #main-container -->

        <%@include file="footer.jsp" %>
    </body>
</html>