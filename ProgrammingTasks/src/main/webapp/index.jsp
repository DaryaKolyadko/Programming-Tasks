<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel="stylesheet" href="resources/css/menu_old.css" media="screen" type="text/css"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
</head>
<body style="min-height:100%; position:relative">
<div>
    <c:import url="WEB-INF/pages/include/menu.jsp"/>
    <table id="tb" width="100%" style="margin-bottom: 3%">
        <tr>
            <td width="15%">
                <c:import url="/WEB-INF/pages/include/userGreeting.jsp"/>
            </td>
            <td width="*" rowspan="2">
                hello
                lalka
                <br><br>lololo
                <br>
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>
            </td>
        </tr>
        <tr>
            <td width="15%">
                <c:import url="/WEB-INF/pages/include/leftMenu.jsp"/>
            </td>
        </tr>
    </table>
        <c:import url="WEB-INF/pages/include/footer.jsp"/>
</body>
</html>