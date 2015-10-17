<%-- 
    Document   : login
    Created on : 16.10.2015, 22:44:34
    Author     : bako
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../layout/header.jsp" %>
${list}
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <form class="form-horizontal">
                <fieldset>
                    <legend>Sign in </legend>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Remember me?
                                </label>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" class="btn btn-primary">Sign in</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>    
</div>
</div>
<%@include file="../layout/footer.jsp" %>
