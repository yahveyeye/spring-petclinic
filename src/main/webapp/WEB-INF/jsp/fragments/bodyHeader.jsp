<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<spring:url value="/resources/images/banner-graphic.png" var="banner"/>
<img src="${banner}"/>

<div class="navbar" style="width: 601px;">
    <div class="navbar-inner">
        <ul class="nav">
            <li style="width: 120px;"><a href="<spring:url value="/" htmlEscape="true" />"><i class="icon-home"></i>
                首页</a></li>
            <li style="width: 150px;"><a href="<spring:url value="/reservations/new" htmlEscape="true" />"><i
                    class="icon-search"></i> 预约</a></li>
            <li style="width: 150px;"><a href="<spring:url value="/reservations/find.html" htmlEscape="true" />"><i
                    class="icon-search"></i> 查询</a></li>
          <%--   <li style="width: 160px;"><a href="<spring:url value="/vets.html" htmlEscape="true" />"><i
                    class="icon-th-list"></i> Veterinarians</a></li>
            <li style="width: 110px;"><a href="<spring:url value="/oups.html" htmlEscape="true" />"

                                        title="trigger a RuntimeException to see how it is handled"><i
                    class="icon-warning-sign"></i> Error</a></li> --%>

        </ul>
    </div>
</div>
	
