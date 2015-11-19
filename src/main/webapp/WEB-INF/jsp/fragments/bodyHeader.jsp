<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%-- <spring:url value="/resources/images/banner.png" var="banner"/>
<img src="${banner}"/> --%>
<div class="b-banner">
	<div class="divleft topdiv">
		<spring:url value="/resources/images/logo-left.png" var="banner"/>
		<img src="${banner}"/>
	</div>
	<div class="divright topdiv">
		<spring:url value="/resources/images/logo-right.png" var="banner"/>
		<img src="${banner}"/>
	</div>
</div>
<!-- <div class="container navdiv">
	<table style="width: 100%">
		<tr>
			<td width="25%">88</td>
			<td  width="50%">99</td>
			<td  width="25%">00</td>
		</tr>
	</table>
</div> -->
 <div class="navbar" style="width: 100%; text-align: center !important;">
    <div class="navbar-inner" style="text-align: center !important;">
        <ul class="nav" >
            <li style="width: 120px;"><a href="<spring:url value="/" htmlEscape="true" />"><i class="icon-home"></i>
                首页</a></li>
            <li style="width: 150px;"><a href="<spring:url value="/reservations/new" htmlEscape="true" />"><i
                    class="icon-search"></i> 预约</a></li>
            <li style="width: 150px;"><a href="<spring:url value="/reservations/find.html" htmlEscape="true" />"><i
                    class="icon-search"></i> 查询</a></li>

        </ul>
    </div>
</div> 

	
