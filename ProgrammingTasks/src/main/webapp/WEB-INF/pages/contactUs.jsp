<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 17.11.2015
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../../resources/css/menu_old.css" media="screen" type="text/css"/>
    <title>Contact us</title>
</head>
<body>
<c:import url="/WEB-INF/pages/include/menu.jsp"/>
<table id="tb" width="100%" style="margin-bottom: 3%">
    <td width="10%">
        <c:import url="/WEB-INF/pages/include/userGreeting.jsp"/>
        <c:import url="/WEB-INF/pages/include/leftMenu.jsp"/>
    </td>
    <td width="*">
        <h2>Contact us</h2>
    </td>
</table>
<c:import url="/WEB-INF/pages/include/footer.jsp"/>
</body>
</html>
