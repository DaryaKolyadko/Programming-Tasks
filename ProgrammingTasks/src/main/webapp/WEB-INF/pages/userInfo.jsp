<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 18.11.2015
  Time: 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="../../resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/menu_old.css" media="screen" type="text/css"/>
    <title>User Info</title>
</head>
<body>
<c:import url="/WEB-INF/pages/include/menu.jsp"/>
<table id="tb" width="100%" style="margin-bottom: 3%">
    <tr>
        <td width="10%">
            <c:import url="/WEB-INF/pages/include/userGreeting.jsp"/>
            <c:import url="/WEB-INF/pages/include/leftMenu.jsp"/>
        </td>
        <td width="*">
            <%--<h2>Имя: <sec:authentication property="name"/></h2>--%>
                <h3>Логин: ${user.username}</h3>
                <h3>Имя: ${user.firstname}</h3>
                <h3>Фамилия: ${user.lastname}</h3>
                <h3>Статус: ${user.status.status}</h3>
                <a class="btn btn-info" style="margin-top: 15px" href="<c:url value="/editUserProfile/${user.username}"/>">Изменить параметры</a>
        </td>
    </tr>
</table>
<c:import url="/WEB-INF/pages/include/footer.jsp"/>
</body>
</html>
