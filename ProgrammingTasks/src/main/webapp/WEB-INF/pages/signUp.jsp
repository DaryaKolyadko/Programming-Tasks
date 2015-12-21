<%--
  Created by IntelliJ IDEA.
  User: Даша
  Date: 26.11.2015
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="../../resources/css/menu_old.css" media="screen" type="text/css"/>
    <link rel="stylesheet" href="../../resources/css/signUp.css" media="screen" type="text/css" />
    <title>Sign Up</title>
</head>
<body>
<c:import url="/WEB-INF/pages/include/menu.jsp"/>
<table id="tb" width="100%" style="margin-bottom: 3%">
    <td width="10%">
        <c:import url="/WEB-INF/pages/include/userGreeting.jsp"/>
        <c:import url="/WEB-INF/pages/include/leftMenu.jsp"/>
    </td>
    <td width="*">
        <div id="login-form">
            <h1>Регистрация</h1>

            <fieldset>
                <form action="<c:url value="/trySignUp"/>" method="get">
                    <input type="text" pattern="[a-zA-Z0-9_.-]{4,8}" required value="Логин"
                           name="username" onBlur="if(this.value=='')this.value='Логин'"
                           onFocus="if(this.value=='Логин')this.value='' "
                           title="Должен содержать не менее 4 и не более 8 символов на выбор: латиницы, цифр,символов ., -, -">
                    Пароль <input type="password" pattern="[a-zA-Z0-9_.-]{8,}" required value="Пароль"
                                  name="password" onBlur="if(this.value=='')this.value='Пароль'"
                                  onFocus="if(this.value=='Пароль')this.value='' " title="Должен содержать не менее 8 символов на выбор: латиницы, цифр, символов ., -, -">
                    Подтвердите пароль <input type="password" required value="Пароль"
                                              onBlur="if(this.value=='')this.value='Пароль'"
                                              onFocus="if(this.value=='Пароль')this.value='' ">
                    <input type="text" required value="Имя" name="firstname"
                           onBlur="if(this.value=='')this.value='Имя'" onFocus="if(this.value=='Имя')this.value='' ">
                    <input type="text" required value="Фамилия" name="lastname"
                           onBlur="if(this.value=='')this.value='Фамилия'"
                           onFocus="if(this.value=='Фамилия')this.value='' ">
                    <input type="submit" value="ЗАРЕГИСТРИРОВАТЬСЯ">
                </form>
            </fieldset>
        </div>
    </td>
</table>
<c:import url="/WEB-INF/pages/include/footer.jsp"/>
</body>
</html>