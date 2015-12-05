<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 26.11.2015
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav role="navigation">
        <ul>
            <li>
                <a href="<c:url value="/home"/>">
                    <div>
                        Домой
                        <span>Назад на главную страницу</span>
                    </div>
                </a>
            </li>
            <%--<sec:authorize access="hasAuthority">--%>
            <sec:authorize access="isAuthenticated()">
            <li>
                <a href="/userInfo">
                    <div>
                        О себе
                        <span>=)</span>
                    </div>
                </a><div>
                <ul>
                    <li><a href="/userInfo">Обо мне</a></li>
                    <li><a href="#">Мои задачи</a></li>
                </ul>
            </div>
            </li>
            </sec:authorize>
            <%--</sec:authorize>--%>
            <li>
                <a href="<c:url value="/contactUs"/>">
                    <div>
                        Контакты
                        <span>Инфа о разработчиках</span>
                    </div>
                </a>
            </li>
            <sec:authorize access="isAuthenticated()">
            <li>
                <a href="<c:url value="/createTask"/>">
                    <div>
                        Добавить задачу
                        <span>Создать новую задачу</span>
                    </div>
                </a>
            </li>
            <li>
                <a href="<c:url value="/j_spring_security_logout"/>">
                    <div>
                        Выход
                    </div>
                </a>
            </li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
            <li>
                <a href="/login">
                    <div>
                        Вход
                        <span>или Регистрация</span>
                    </div>
                </a><div>
                <ul>
                    <li><a href="/login">Вход</a></li>
                    <li><a href="/sign_up">Регистрация</a></li>
                </ul>
            </div>
            </li>
            </sec:authorize>
            <div style="width: 200px; padding: 10px; margin-left: auto;" title="Готовы пошевелить извилинами? =)">
                <img src="../../../resources/img/creative-brain_converted.png">
            </div>
        </ul>
        <%--<div>--%>
        <%--<h1>Русский | Английский</h1>--%>
        <%--</div>--%>
    </nav>
</header>
