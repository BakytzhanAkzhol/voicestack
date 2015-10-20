<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../layout/header.jsp" %>
<style>
    .player{
        z-index: -1;
        border-radius: 100%;
    }
    .action-player{
        display:none;
    }
</style>
<div class="container">
    <h3>Administration: User list</h3>
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <table class="table table-bordered table-striped table-responsive table-condensed">
                <thead>

                <th>ID</th>
                <th>User</th>
                <th>Category</th>
                <th>Record</th>
                <th>Content</th>
                <th>Create date</th>
                <th>Update date</th>
                <th>Status</th>
                <th></th>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="element"> 
                        <tr>
                            <td>${element.id}</td>
                            <td>${element.user_id}</td>
                            <td>${element.category_id}</td>
                            <td>${element.record_id}</td>
                            <td>${element.content}</td>
                            <td>${element.create_date}</td>
                            <td>${element.update_date}</td>
                            <td>${element.status}</td>
                            <td> <a href="<%=request.getContextPath()%>/question/${element.id}/view.htm" class="btn btn-primary btn-sm">View</a>
            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>
    </div>    
</div>
</div>
<%@include file="../../layout/footer.jsp" %>
