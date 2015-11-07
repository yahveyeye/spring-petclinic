<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>查询</h2>

    <spring:url value="/reservations.html" var="formUrl"/>
    <form:form modelAttribute="reservation" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-reservation-form">
        <fieldset>
            <div class="control-group" id="lastName">
                <label class="control-label">身份证号码 </label>
                <form:input path="lastName" size="30" maxlength="80"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div class="form-actions">
                <button type="submit">查询</button>
            </div>
        </fieldset>
    </form:form>

    <br/>
   <%--  <a href='<spring:url value="/reservations/new" htmlEscape="true"/>'>Add Owner</a> --%>

    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>
