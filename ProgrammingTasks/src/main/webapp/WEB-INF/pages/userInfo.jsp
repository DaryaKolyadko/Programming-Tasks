<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 18.11.2015
  Time: 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/menu.css" media="screen" type="text/css" />
    <title>User Info</title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/include/menu.jsp"></jsp:include>
<table id="tb" width="100%" style="margin-bottom: 3%">
    <td width="10%">
        <jsp:include page="/WEB-INF/pages/include/leftMenu.jsp"></jsp:include>
    </td>
    <td width="*">
            <h2>UserInfo</h2>
    </td>
</table>
<jsp:include page="/WEB-INF/pages/include/footer.jsp"></jsp:include>
</body>
</html>
