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
<jsp:include page="../fragments/bodyHeader.jsp"/>

<div class="container">
    <div style="width: 800px; height:200px; background-color: #5b9be0;padding-top: 10px;">
    
    </div>
    <%-- <c:choose>
        <c:when test="${reservation['new']}"><c:set var="method" value="post"/></c:when>
        <c:otherwise><c:set var="method" value="put"/></c:otherwise>
    </c:choose>

    <h2>
        <c:if test="${reservation['new']}">新</c:if>预约
    </h2>
    <form:form modelAttribute="reservation" method="${method}" class="form-horizontal" id="add-reservation-form">
        <petclinic:inputField label="姓名" name="personName"/>
        <petclinic:inputField label="身份证号" name="idCardNo" />
        <petclinic:inputField label="手机号" name="phone"/>
        <petclinic:inputField label="电子邮箱" name="email"/>
        <petclinic:inputField label="qq号" name="qq"/>



        <div class="form-actions">
            <c:choose>
                <c:when test="${reservation['new']}">
                    <button type="submit">预约</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">保存</button>
                </c:otherwise>
            </c:choose>
        </div>
    </form:form> --%>
</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>

</html>
