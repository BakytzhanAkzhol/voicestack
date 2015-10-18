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
            <div class="row">
                <div class="list-group">
                    <div class="list-group-item">
                        <div class="row-picture">
                            <div class="player">
                                <img class="circle " src="http://lorempixel.com/56/56/people/1" alt="icon">
                                <span class="action-player">listen</span>
                            </div>
                        </div>
                        <div class="row-content">
                            <div class="least-content">Время</div>
                            <h4 class="list-group-item-heading">Категория</h4>
                            <p class="list-group-item-text">
                                Короткое описание вопроса
                            <div class="progress">
                                <div class="progress-bar progress-bar-info" style="width: 20%"></div>
                            </div></p>

                        </div>

                    </div>
                    <div class="list-group-separator"></div>
                </div>
            </div>

        </div>
    </div>    
</div>
</div>
<%@include file="../../layout/footer.jsp" %>
