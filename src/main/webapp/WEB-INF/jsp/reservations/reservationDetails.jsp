<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>

<body>
 <jsp:include page="../fragments/bodyHeader.jsp"/>
<div class="container">
   <div class="centerdiv" style="background-color: #ffffff;"> 
	<br/>
    <h2>预约成功</h2>

    <table class="table table-striped" style="width:100%;">
        <tr>
            <th style="text-align: right;">预约号</th>
            <td><b><c:out value="${reservation.id} "/></b></td>
        </tr>
        <tr>
            <th style="text-align: right;">姓名</th>
            <td><b><c:out value="${reservation.personName} "/></b></td>
        </tr>
        <tr>
            <th style="text-align: right;">身份证号</th>
            <td><c:out value="${reservation.idCardNo}"/></td>
        </tr>
        <tr>
            <th style="text-align: right;">手机号</th>
            <td><c:out value="${reservation.phone}"/></td>
        </tr>
        <tr>
            <th style="text-align: right;">电子邮箱</th>
            <td><c:out value="${reservation.email}"/></td>
        </tr>
        <tr>
            <th style="text-align: right;">qq号</th>
            <td><c:out value="${reservation.qq}"/></td>
        </tr>
        <tr>
            <th></th>
            <td></td>
        </tr>
         <%-- <tr>
            <td> 
            	<spring:url value="{reservationId}/edit.html" var="editUrl">
                    <spring:param name="reservationId" value="${reservation.id}"/>
                </spring:url>
                <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit Reservation</a></td>
           </td>
        </tr> --%>
    </table>
    <br/>
	</div>
   

    <jsp:include page="../fragments/footer.jsp"/>

</div>

</body>

</html>
