<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 20.12.2015
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <link href="../../resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
    <link href="../../resources/css/menu_old.css" rel="stylesheet"/>
    <link href="../../resources/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
          rel="stylesheet" type="text/css">
    <script src="../../resources/js/bootstrap/bootstrap.min.js"></script>
    <script src="../../resources/js/jquery-1.11.3.min.js"></script>
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
            <div class="centerForm ">
                <form:form id="userForm" commandName="user" method="post" action="/saveProfile">

                    <div class="form-group">
                        <label for="username">Логин</label>
                        <form:input path="username" class="form-control">${userToEdit.username}</form:input>
                    </div>
                    <div class="form-group">
                        <label for="firstname">Имя</label>
                        <form:input path="firstname" class="form-control">${userToEdit.firstname}</form:input>
                    </div>
                    <div class="form-group">
                        <label for="lastname">Фамилия</label>
                        <form:input path="lastname" class="form-control">${userToEdit.lastname}</form:input>
                    </div>
                    <%--<div class="form-group">--%>
                    <%--<label for="userRolesSet">Roles</label>--%>
                    <%--<form:select path="userRolesSet" multiple="true" class="form-control">--%>
                    <%--<form:options items="${roleList}" itemValue="role" itemLabel="role" />--%>
                    <%--</form:select>--%>
                    <%--</div>--%>
                    <div class="btn-group " role="group">
                        <button type="submit" class="btn btn-default">Сохранить</button>
                        <a href="<c:url value='/programmingtasks'/>" class="btn btn-default">Отмена</a>
                    </div>
                </form:form>
            </div>
        </td>
    </tr>
</table>
<c:import url="/WEB-INF/pages/include/footer.jsp"/>
</body>
</html>
