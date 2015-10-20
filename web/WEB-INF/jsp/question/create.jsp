<%-- 
    Document   : login
    Created on : 16.10.2015, 22:44:34
    Author     : bako
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../../layout/header.jsp" %>
${list}
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <form:form method="POST" action="registrate.htm" class="form-horizontal" modelAttribute="registration">

                    <fieldset>
                        <legend>Create new question</legend>
                        <div class="form-group">
                            <label for="inputName" class="col-lg-2 control-label">Content</label>
                            <div class="col-lg-10">
                                <form:input path="content"  class="form-control" placeholder="Your name"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputLastName" class="col-lg-2 control-label">Record</label>
                            <div class="col-lg-10">
                                <form:input path="record_id"  class="form-control" placeholder="Your last name"  />
                            </div>
                        </div>
                        <div class="separate"></div>
                        <div class="form-group">
                            <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                            <div class="col-lg-10">
                                <form:password path="password_hash"  class="form-control" placeholder="Password"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword" class="col-lg-2 control-label">Repeat password</label>
                            <div class="col-lg-10">
                                <form:password path="password_hash"  class="form-control" placeholder="Repeat password"  />
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" class="btn btn-primary">Sign in</button>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </form:form>
        </div>
    </div>    
</div>
</div>
<%@include file="../../layout/footer.jsp" %>
