<%-- 
    Document   : login
    Created on : 16.10.2015, 22:44:34
    Author     : bako
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../layout/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <form:form method="POST" action="loginSubmit.htm" class="form-horizontal" modelAttribute="login">

                <fieldset>
                    <legend>Sign in </legend>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <form:input path="email"  class="form-control" placeholder="Email"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                        <div class="col-lg-10">
                            <form:password path="password_hash"  class="form-control" placeholder="Password" />
                            <div class="checkbox">
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" class="btn btn-primary">Sign in</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>    
</div>
</div>
<%@include file="../../layout/footer.jsp" %>
