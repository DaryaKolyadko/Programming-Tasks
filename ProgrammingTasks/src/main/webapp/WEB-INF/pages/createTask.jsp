<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 17.11.2015
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CreateTask</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/menu_old.css" media="screen" type="text/css"/>
</head>
<body>
<c:import url="/WEB-INF/pages/include/menu.jsp"/>
<table id="tb" width="100%" style="margin-bottom: 5%">
    <tr>
        <td width="10%">
            <c:import url="/WEB-INF/pages/include/userGreeting.jsp"/>
            <c:import url="/WEB-INF/pages/include/leftMenu.jsp"/>
        </td>
        <td width="*">
    <div id="createTaskForm">
        <h1>Создание задачи</h1>
        <br>
        <div class="form-group">
            <label class = "col-md-2 control-label">
                Название задачи:
            </label>
            <div class="col-md-10">
                <input class="form-control" style="width: 40%" onBlur="if(this.value=='')this.value='Новая задача'"  onFocus="if(this.value=='Новая задача')this.value='' ">
            </div>
        </div>
        <br />
        <br />
        <br />
        <div class="form-group">
            <label class = "col-md-2 control-label">
                Категория задачи:
            </label>
            <div class="col-md-10">
                <select class = "form-control" style="width: 10%">
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category.categoryName}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <br />
        <br />
        <br />

        <div class="form-group">
            <label class = "col-md-2 control-label">
                Уровень сложности:
            </label>
            <div class="col-md-10">
                <select class = "form-control" style="width: 10%">
                    <c:forEach items="${complexityLevelList}" var="complexityLevel">
                        <option value="${complexityLevel.complexityLevelName}">${complexityLevel.complexityLevelName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <br />
        <br />
        <br />
        <div class="form-group">
            <label class = "col-md-2 control-label">
                Теги:
            </label>
            <div class="col-md-10">
                <input class="form-control" style="width: 40%">
            </div>
        </div>
        <br />
        <br />
        <br />
        <div class="form-group">
            <label class = "col-md-2 control-label">
                Условие задачи:
            </label>
            <div class="col-md-10">
                <textarea class="form-control" style="height:300px; width: 100%; resize: none; margin-bottom: 40px" onBlur="if(this.value=='')this.value='Условие задачи'"  onFocus="if(this.value=='Условие задачи')this.value=''"></textarea>
            </div>
        </div>
        <br />
        <br />
        <br />
        <div class="form-group">
            <label class = "col-md-2 control-label">
                Решение задачи:
            </label>
            <div class="col-md-10">
                <textarea class="form-control" style= "height:150px; width:100%; resize: none; margin-bottom: 40px" onBlur="if(this.value=='')this.value='Решение задачи'"  onFocus="if(this.value=='Решение задачи')this.value=''"></textarea>
            </div>
        </div>
        <br />
        <br />
        <br />
    </div>
    <input class="btn btn-default" type="submit" style="margin: 15px; margin-left: 50%" value="Сохранить задачу" />
        </td>
</table>
<c:import url="/WEB-INF/pages/include/footer.jsp"/>
</body>
</html>
