<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
</body>
<script src="<c:url value='/res/js/jquery-1.10.2.min.js' />"></script>
<script src="<c:url value='/res/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/res/js/material.min.js' />"></script>
<script src="<c:url value='/res/js/material.min.js' />"></script>
<script src="<c:url value='/res/js/ripples.min.js' />"></script>
<script src="<c:url value='/res/js/nouislider.min.js' />"></script>
<script src="//fezvrasta.github.io/snackbarjs/dist/snackbar.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/noUiSlider/6.2.0/jquery.nouislider.min.js"></script>
<script>
    
    $(document).ready(function () {
        // This command is used to initialize some elements and make them work properly
        $.material.init();
        $(".player").hover(function(){
            $(this).children(".action-player").css({"display":"block"});
        });
        $(".player").focusout(function(){
            $(this).children(".action-player").css({"display":"none"});
        });
    });
</script>
</html>

