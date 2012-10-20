<%-- 
    Document   : mainnavbar
    Created on : 20 Oct 2012, 1:09:05 PM
    Author     : Lance
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
</style>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Project name</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="about.html">About</a></li>
                    <li><a href="contact.html">Contact</a></li>
                    <sec:authorize access="hasRole('user')">
                        <li><a href="mygarage.html">My Garage</a></li>
                    </sec:authorize>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li class="nav-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="navbar-form pull-right">
                    <sec:authorize access="isAnonymous()">
                        <form action="j_spring_security_check" method="POST">
                            <input class="span2" type="text" name="j_username" id="j_username" placeholder="Email" />
                            <input class="span2" type="password" name="j_password" id="j_password" placeholder="Password" />
                            <button type="submit" class="btn">Log in</button>
                            <a href="signup.html">
                                <button type="button" class="btn">Sign up</button>
                            </a>
                        </form>
                    </sec:authorize>
                    <sec:authorize access="hasRole('user')">
                        <a href="j_spring_security_logout">
                            <button type="button" class="btn">Log Out</button>
                        </a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</div>
