<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 17.11.2015
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CreateTask</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/menu_old.css" media="screen" type="text/css"/>
    <script src="../../resources/js/create-task-validate.js"></script>
    <script src="../../resources/js/jquery-1.11.3.min.js"></script>
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
            <form:form action="successTaskCreating" commandName="newTask" method="post">
                <div id="createTaskForm">
                    <h1>Создание задачи</h1>
                    <br>
                    <div class="form-group">
                        <label for="taskName" class="col-md-2 control-label">
                            Название задачи:
                        </label>

                        <div class="col-md-10">
                            <form:input class="form-control" style="width: 40%"
                                   onBlur="if(this.value=='')this.value='Новая задача'"
                                   onFocus="if(this.value=='Новая задача')this.value='' "
                                   name="taskName"
                                   id="taskName" path="taskName"/>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label for="category" class="col-md-2 control-label">
                            Категория задачи:
                        </label>

                        <div class="col-md-10">
                            <form:select class="form-control" id="category" name="category" style="width: 10%" path="category">
                                <c:forEach items="${categoryList}" var="category_var">
                                    <form:option value="${category_var.categoryName}">${category_var.categoryName}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label for="complexityLevel" class="col-md-2 control-label">
                            Уровень сложности:
                        </label>

                        <div class="col-md-10">
                            <form:select path="complexityLevel" id="complexityLevel" class="form-control" style="width: 10%" name="complexityLevel">
                                <c:forEach items="${complexityLevelList}" var="complexity_level">
                                    <form:option value="${complexity_level.complexityLevelName}">${complexity_level.complexityLevelName}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label for="tagLine" class="col-md-2 control-label">
                            Теги:
                        </label>

                        <div class="col-md-10">
                            <input id="tagLine" pattern="(#[a-zA-Z0-9а-яА-Я]*[ ]*)*" class="form-control"
                                   required="true" name="tagLine" style="width: 40%"
                                   title="Список тегов через один или несколько пробелов в виде #tag"/>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label for="task" class="col-md-2 control-label">
                            Условие задачи:
                        </label>

                        <div class="col-md-10">
                            <form:textarea class="form-control"
                                      style="height:300px; width: 100%; resize: none; margin-bottom: 40px"
                                      onBlur="if(this.value=='')this.value='Условие задачи'"
                                      onFocus="if(this.value=='Условие задачи')this.value=''"
                                      name="task" path="task" id="task"/>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <br/>

                    <div class="form-group">
                        <label for="solution" class="col-md-2 control-label">
                            Решение задачи:
                        </label>

                        <div class="col-md-10">
                            <form:textarea class="form-control"
                                      style="height:150px; width:100%; resize: none; margin-bottom: 40px"
                                      onBlur="if(this.value=='')this.value='Решение задачи'"
                                      onFocus="if(this.value=='Решение задачи')this.value=''"
                                      name="solution" path="solution" id="solution"/>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <br/>
                </div>
                <input class="btn btn-default" type="submit" style="margin: 15px; margin-left: 50%"
                       value="Сохранить задачу"/>
            </form:form>
        </td>
</table>
<c:import url="/WEB-INF/pages/include/footer.jsp"/>
</body>
</html>