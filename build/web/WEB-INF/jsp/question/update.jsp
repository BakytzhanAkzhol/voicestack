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
     <a href="<%=request.getContextPath()%>/question/index.htm" class="btn btn-default">< Back to Home</a>
     
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <h4>Update question: <b>${element.id}</b></h4><br>
            <table class="table table-bordered table-striped">
                <tbody>
                    <form:form method="POST" action="${root_link}/question/${element.id}/update.htm" class="form-horizontal" modelAttribute="element">
                        <tr>
                            <td>Category</td>
                            <td><form:input path="category_id"  class="form-control" placeholder="Category"  /></td>
                        </tr>
                        <tr>
                            <td>Record</td>
                            <td><form:input path="record_id"  class="form-control" placeholder="Record"  /></td>
                        </tr>
                        <tr>
                            <td>Status</td>
                            <td><form:input path="status"  class="form-control" placeholder="Email"  /></td>
                        </tr>
                        <tr>
                            <td>Content</td>
                            <td><form:textarea path="content"  class="form-control" placeholder="Email"  /></td>
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
