<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 20.12.2015
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../../resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/menu_old.css" media="screen" type="text/css"/>
    <link rel="stylesheet" href="../../resources/css/taskList.css" media="screen" type="text/css" />
    <title>Task was created</title>
</head>
<body>
<c:import url="/WEB-INF/pages/include/menu.jsp"/>
<table id="tb" width="100%" style="margin-bottom: 3%">
    <tr>
        <td width="10%">
            <c:import url="/WEB-INF/pages/include/userGreeting.jsp"/>
            <c:import url="/WEB-INF/pages/include/leftMenu.jsp"/>
        </td>
        <td>
            <h2>Мои задачи</h2>

            <div id="taskList">
                <c:forEach items="${tasks}" var="myTask" >
                <div id="task">
                    <br>
                    <div class="form-group">
                        <label id="task-name">
                            ${myTask.taskName}
                        </label>
                        <div class="btn-group " role="group" style="margin-left: 20px">
                            <a class="btn btn-default" style="margin-top: 15px" href="<c:url value="/mainPage"/>">Изменить</a>
                            <a class="btn btn-danger" style="margin-top: 15px" href="<c:url value="/deleteTask/${myTask.taskId}"/>"> Удалить</a>
                            <!--<a href="<c:url value='/programmingtasks'/> class="btn btn-default">Cancel!-->
                        </div>
                    </div>
                    <a id="task-cathegory" href="">
                        [${myTask.category.categoryName}]
                    </a><br>
                    <div id="tagList" style="margin-left: 20px">
                        [<c:forEach items="${myTask.tags}" var="tag">
                            <a href="">${tag.tagName}  </a>
                        </c:forEach>]
                        <br>
                    </div>
                    <a id="task-complexity-level" href="">
                        [${myTask.complexityLevel.complexityLevelName}]
                    </a>
                    <div class="form-group">
                        <label style="margin:15px;">
                <pre>${myTask.task}</pre></label>
                    </div>
                    </div>
                    <div id="solution-div" class="bg-success">
                        <a id="solution" href="">${myTask.solution}  </a>
                    </div>
                    <hr>
                    </c:forEach>
                </div>
        </td>
    </tr>
</table>
<c:import url="/WEB-INF/pages/include/footer.jsp"/>
</body>
</html>
