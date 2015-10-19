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
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <table class="table table-bordered table-striped table-responsive table-condensed">
                <thead>

                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th></th>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="element"> 
                        <tr>
                            <td>${element.id}</td>
                            <td>${element.name}</td>
                            <td>${element.surname}</td>
                            <td>${element.email}</td>
                            <td> <a href="<%=request.getContextPath()%>/user/${element.id}/view.htm" class="btn btn-primary btn-sm">View</a>
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
