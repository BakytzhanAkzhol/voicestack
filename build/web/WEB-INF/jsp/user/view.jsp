<%-- 
    Document   : login
    Created on : 16.10.2015, 22:44:34
    Author     : bako
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../../layout/header.jsp" %>
${list}
<div class="container">
     <a href="<%=request.getContextPath()%>/user/index.htm" class="btn btn-default">< Back to Home</a>
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <a href="<%=request.getContextPath()%>/user/${user.id}/update.htm" class="btn btn-primary pull-left">Update</a>
             <form:form method="POST" action="${root_link}/user/${user.id}/remove.htm">
                 <button type="submit" class="btn btn-danger pull-right center-block">Remove user</button>
             </form:form>
            <table class="table table-bordered table-striped">
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>${user.id}</td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>${user.name}</td>
                    </tr>
                    <tr>
                        <td>Surname</td>
                        <td>${user.surname}</td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>${user.email}</td>
                    </tr>
                    <tr>
                        <td>Password_hash</td>
                        <td>${user.password_hash}</td>
                    </tr>
                    <tr>
                        <td>Create date</td>
                        <td>${user.create_date}</td>
                    </tr>
                    <tr>
                        <td>Update date</td>
                        <td>${user.update_date}</td>
                    </tr>
                    <tr>
                        <td>Moderator id</td>
                        <td><a href="<%=request.getContextPath()%>/user/${user.moder_id}/view.htm">${user.moder_id}</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>    
</div>
</div>
<%@include file="../../layout/footer.jsp" %>
