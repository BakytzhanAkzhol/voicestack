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
     <a href="<%=request.getContextPath()%>/user/index.htm" class="btn btn-default">< Back to Home</a>
     
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <h4>Update user: <b>${user.email}</b></h4><br>
            <table class="table table-bordered table-striped">
                <tbody>
                    <form:form method="POST" action="${root_link}/user/${user.id}/update.htm" class="form-horizontal" modelAttribute="user">
                        <tr>
                            <td>Name</td>
                            <td><form:input path="name"  class="form-control" placeholder="name"  /></td>
                        </tr>
                        <tr>
                            <td>Surname</td>
                            <td><form:input path="surname"  class="form-control" placeholder="Surname"  /></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><form:input path="email"  class="form-control" placeholder="Email"  /></td>
                        </tr>
                    <button type="submit" class="btn btn-success">Save</button>
                    </form:form>
                </tbody>
                
            </table>
        </div>
    </div>    
</div>
</div>
<%@include file="../../layout/footer.jsp" %>
