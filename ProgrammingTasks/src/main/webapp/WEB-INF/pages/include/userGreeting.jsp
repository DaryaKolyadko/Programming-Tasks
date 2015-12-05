<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 18.11.2015
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="../../../resources/css/leftMenu.css" media="screen" type="text/css" />
<sec:authorize access="isAuthenticated()">
    <%--<c:if test="${username != null }">--%>
        <div id="user-greeting"><h1>Hello,  <b><sec:authentication property="name" /></b>!</h1></div>
    <%--</c:if>--%>
</sec:authorize>