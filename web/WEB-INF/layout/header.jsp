<%@page import="model.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link  type="text/css" href="<c:url value="/res/css/bootstrap.min.css"/>" rel="stylesheet">
        <link  type="text/css" href="<c:url value="/res/css/material-fullpalette.min.css"/>" rel="stylesheet">
        <link  type="text/css" href="<c:url value="/res/css/ripples.min.css"/>" rel="stylesheet">
        <link  type="text/css" href="<c:url value="/res/css/roboto.css" />" rel="stylesheet">
        <link  type="text/css" href="<c:url value="/res/css/nouislider.min.css" />" rel="stylesheet">
        <link href="//fezvrasta.github.io/snackbarjs/dist/snackbar.min.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <%! User user;%>
        <% user = (User) session.getAttribute("userSession"); %>
        <% if (user != null) { %>
        <div class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="javascript:void(0)">Brand</a>
            </div>
            <div class="navbar-collapse collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="javascript:void(0)">Main</a></li>
                    <li><a href="javascript:void(0)">Popular answers</a></li>
                    <li class="dropdown">
                        <a href="bootstrap-elements.html" data-target="#" class="dropdown-toggle" data-toggle="dropdown">Settings<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/user/profile.htm">Profile</a></li>
                            <li><a href="javascript:void(0)">Settings</a></li>
                            <li><a href="javascript:void(0)">Helps</a></li>
                            <li class="divider"></li>
                            <li><a href="<%=request.getContextPath()%>/user/logout.htm">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <% }else{%>
        
           <div class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="javascript:void(0)">Brand</a>
            </div>
            <div class="navbar-collapse collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="javascript:void(0)">Main</a></li>
                    <li><a href="javascript:void(0)">Popular answers</a></li>
                    <li class="dropdown">
                        <a href="bootstrap-elements.html" data-target="#" class="dropdown-toggle" data-toggle="dropdown">Settings<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/user/login.htm">Sign in</a></li>
                            <li><a href="javascript:void(0)">Helps</a></li>
                            <li class="divider"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <% } %>
        