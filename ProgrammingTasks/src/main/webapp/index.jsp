<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/css/menu.css" media="screen" type="text/css"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
</head>
<body style="min-height:100%; position:relative">
<div>
    <jsp:include page="WEB-INF/pages/include/menu.jsp"></jsp:include>
    <table id="tb" width="100%" style="margin-bottom: 3%">
        <tr>
            <td width="15%">
                <jsp:include page="/WEB-INF/pages/include/userGreeting.jsp"></jsp:include>
            </td>
            <td width="*" rowspan="2">
                hello
            </td>
        </tr>
        <tr>
            <td width="15%">
                <jsp:include page="/WEB-INF/pages/include/leftMenu.jsp"></jsp:include>
            </td>
        </tr>
    </table>
    <jsp:include page="WEB-INF/pages/include/footer.jsp"></jsp:include>
</body>
</html>