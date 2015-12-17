<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel="stylesheet" href="resources/css/menu.css" media="screen" type="text/css"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
</head>
<body style="min-height:100%; position:relative">
<div>
    <%--<c:import url="WEB-INF/pages/include/menu.jsp"/>--%>
        <header>
            <nav role="navigation">
                <ul>
                    <li class="header_nav_ul_li">
                        <a href="<c:url value="/home"/>">
                            <div>
                                Домой
                                <span>Назад на главную страницу</span>
                            </div>
                        </a>
                    </li>
                    <%--<sec:authorize access="hasAuthority">--%>
                    <sec:authorize access="isAuthenticated()">
                        <li class="header_nav_ul_li">
                            <a href="userInfo">
                                <div>
                                    О себе
                                    <span>=)</span>
                                </div>
                            </a><div>
                            <ul>
                                <li><a href="userInfo">Обо мне</a></li>
                                <li><a href="#">Мои задачи</a></li>
                            </ul>
                        </div>
                        </li>
                    </sec:authorize>
                    <%--</sec:authorize>--%>
                    <li class="header_nav_ul_li">
                        <a href="<c:url value="/contactUs"/>">
                            <div>
                                Контакты
                                <span>Инфа о разработчиках</span>
                            </div>
                        </a>
                    </li>
                    <sec:authorize access="isAuthenticated()">
                        <li class="header_nav_ul_li">
                            <a href="<c:url value="/createTask"/>">
                                <div>
                                    Добавить задачу
                                    <span>Создать новую задачу</span>
                                </div>
                            </a>
                        </li>
                        <li class="header_nav_ul_li">
                            <a href="<c:url value="/j_spring_security_logout"/>">
                                <div>
                                    Выход
                                </div>
                            </a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <li class="header_nav_ul_li">
                            <a href="login">
                                <div>
                                    Вход
                                    <span>или Регистрация</span>
                                </div>
                            </a><div>
                            <ul>
                                <li><a href="login">Вход</a></li>
                                <li><a href="sign_up">Регистрация</a></li>
                            </ul>
                        </div>
                        </li>
                    </sec:authorize>
                    <div style="width: 200px; padding: 10px; margin-left: auto;" title="Готовы пошевелить извилинами? =)">
                        <img src="../../resources/img/creative-brain_converted.png">
                    </div>
                </ul>
            </nav>
        </header>
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