<!DOCTYPE html>

<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<html lang="en">

<jsp:include page="fragments/staticFiles.jsp"/>

<body onload="imgW()">
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="content">
    <spring:url value="/resources/images/5.png" htmlEscape="true" var="petsImage"/>
    <img src="${petsImage}"/>

   <%--  <jsp:include page="fragments/footer.jsp"/> --%>

</div>
</body>
<script>
       function imgW() {
            var w=document.body.clientWidth;
           // alert(w);
            var pic =document.getElementsByName("imgW");
            //alert(pic.length);
            for(var i=0;i<pic.length;i++){
                var width1=pic[i].width; 
                var height1=pic[i].height; 
                pic[i].width=w;
                pic[i].height=height1*w/width1; 
            }
        }
        
    </script>
</html>
