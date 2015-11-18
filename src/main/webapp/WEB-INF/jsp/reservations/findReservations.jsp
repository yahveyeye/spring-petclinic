<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>

<body>
<jsp:include page="../fragments/bodyHeader.jsp"/>
<div class="container">
    
	 <div class="centerdiv"> 
	  <br/>
    <h2>查询</h2>

    <spring:url value="/reservations.html" var="formUrl"/>
    <form:form modelAttribute="reservation" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-reservation-form">
        <fieldset>
            <div class="control-group" id="personName">
                <label class="control-label">姓名 </label>
                <div  style="text-align: left !important;" >
                &nbsp;&nbsp;&nbsp;&nbsp;<form:input path="personName" size="30" maxlength="80"/>
                </div>
                <span class="help-inline"><form:errors path="personName"/></span>
            </div>
            <div class="control-group" id="idCardNo">
                <label class="control-label">身份证号码 </label>
                <div  style="text-align: left !important;" >
                	 &nbsp;&nbsp;&nbsp;&nbsp;<form:input path="idCardNo" size="30" maxlength="80"/>
                </div>
                <span class="help-inline"><form:errors path="idCardNo"/></span>
            </div>
            
            <div >
                <button type="submit" class="buttonbg">查询</button>
            </div>
        </fieldset>
    </form:form>

    <br/>
  </div>
   <%--  <a href='<spring:url value="/reservations/new" htmlEscape="true"/>'>Add Owner</a> --%>

    <%-- <jsp:include page="../fragments/footer.jsp"/> --%>

</div>
</body>

</html>
