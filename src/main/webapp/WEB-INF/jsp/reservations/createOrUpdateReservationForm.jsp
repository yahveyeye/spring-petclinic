<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <c:choose>
        <c:when test="${reservation['new']}"><c:set var="method" value="post"/></c:when>
        <c:otherwise><c:set var="method" value="put"/></c:otherwise>
    </c:choose>

    <h2>
        <c:if test="${reservation['new']}">新</c:if>预约
    </h2>
    <form:form modelAttribute="reservation" method="${method}" class="form-horizontal" id="add-reservation-form">
        <petclinic:inputField label="First Name" name="firstName"/>
        <petclinic:inputField label="Last Name" name="lastName"/>
        <petclinic:inputField label="Address" name="address"/>
        <petclinic:inputField label="City" name="city"/>
        <petclinic:inputField label="Telephone" name="telephone"/>

        <div class="form-actions">
            <c:choose>
                <c:when test="${reservation['new']}">
                    <button type="submit">创建</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">更新</button>
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>

</html>
