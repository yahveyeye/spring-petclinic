<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    
    
    <datatables:table id="reservations" data="${selections}" row="reservation" theme="bootstrap2" 
                      cssClass="table table-striped" pageable="ture" info="false" export="xls">
       <%--  <datatables:column title="姓名" display="xls">
        <c:out value="${reservation.personName}"/>
        </datatables:column> --%>
        <datatables:column title="预约号" property="id" cssStyle="width: 30px;" />
        <datatables:column title="姓名" property="personName" cssStyle="width: 50px;"/>
        <datatables:column title="身份证号" property="idCardNo" cssStyle="width: 70px;"/>
        <datatables:column title="电子邮箱" property="email" cssStyle="width: 50px;"/>
        <datatables:column title="手机号" property="phone" cssStyle="width: 50px;"/>
        <datatables:column title="QQ号" property="qq" cssStyle="width: 50px;"/>
            
        <datatables:export type="xls" cssClass="btn" cssStyle="height: 25px;" />
    </datatables:table>
    
    
    
   <%--  <datatables:table id="owners" data="${selections}" row="owner" theme="bootstrap2" 
                      cssClass="table table-striped" pageable="false" info="false" export="pdf">
        <datatables:column title="姓名" cssStyle="width: 150px;" display="html">
            <spring:url value="/owners/{ownerId}.html" var="ownerUrl">
                <spring:param name="ownerId" value="${owner.id}"/>
            </spring:url>
            <a href="${fn:escapeXml(ownerUrl)}"><c:out value="${owner.personName}"/></a>
        </datatables:column>
        <datatables:column title="姓名" display="pdf">
            <c:out value="${owner.personName}"/>
        </datatables:column>
        <datatables:column title="Address" property="address" cssStyle="width: 200px;"/>
        <datatables:column title="City" property="city"/>
        <datatables:column title="Telephone" property="telephone"/>
        <datatables:column title="Pets" cssStyle="width: 100px;">
            <c:forEach var="pet" items="${owner.pets}">
                <c:out value="${pet.name}"/>
            </c:forEach>
        </datatables:column>
        <datatables:export type="pdf" cssClass="btn" cssStyle="height: 25px;" />
    </datatables:table> --%>
    
    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>
