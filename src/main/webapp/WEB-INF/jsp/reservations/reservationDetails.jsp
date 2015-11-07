<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>Reservation Information</h2>

    <table class="table table-striped" style="width:600px;">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${reservation.firstName} ${reservation.lastName}"/></b></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><c:out value="${reservation.address}"/></td>
        </tr>
        <tr>
            <th>City</th>
            <td><c:out value="${reservation.city}"/></td>
        </tr>
        <tr>
            <th>Telephone</th>
            <td><c:out value="${reservation.telephone}"/></td>
        </tr>
         <tr>
            <td> 
            	<spring:url value="{reservationId}/edit.html" var="editUrl">
                    <spring:param name="reservationId" value="${reservation.id}"/>
                </spring:url>
            <%--     <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit Reservation</a></td> --%>
           
        </tr>
    </table>

   

    <jsp:include page="../fragments/footer.jsp"/>

</div>

</body>

</html>
