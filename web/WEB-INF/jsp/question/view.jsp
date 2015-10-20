<%-- 
    Document   : login
    Created on : 16.10.2015, 22:44:34
    Author     : bako
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../../layout/header.jsp" %>
<div class="container">
     <a href="<%=request.getContextPath()%>/question/index.htm" class="btn btn-default">< Back to Home</a>
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <a href="<%=request.getContextPath()%>/question/${element.id}/update.htm" class="btn btn-primary pull-left">Update</a>
             <form:form method="POST" action="${root_link}/question/${element.id}/remove.htm">
                 <button type="submit" class="btn btn-danger pull-right center-block">Remove question</button>
             </form:form>
            <table class="table table-bordered table-striped">
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>${element.id}</td>
                    </tr>
                    <tr>
                        <td>User</td>
                        <td>${element.user_id}</td>
                    </tr>
                    <tr>
                        <td>Category</td>
                        <td>${element.category_id}</td>
                    </tr>
                    <tr>
                        <td>Record</td>
                        <td>${element.record_id}</td>
                    </tr>
                    <tr>
                        <td>Content</td>
                        <td>${element.content}</td>
                    </tr>
                    <tr>
                        <td>Create date</td>
                        <td>${element.create_date}</td>
                    </tr>
                    <tr>
                        <td>Update date</td>
                        <td>${element.update_date}</td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td>${element.status}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>    
</div>
</div>
<%@include file="../../layout/footer.jsp" %>
