<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav role="navigation">
        <ul>
            <li>
                <a href="<c:url value="/home"/>">
                    <div>
                        Home
                        <span>Back to main page</span>
                    </div>
                </a>
            </li>
            <%--<sec:authorize access="hasAuthority">--%>
            <li>
                <a href="/userInfo">
                    <div>
                        About me
                        <span>=)</span>
                    </div>
                </a><div>
                    <ul>
                        <li><a href="/userInfo">About me</a></li>
                        <li><a href="#">My tasks</a></li>
                    </ul>
                </div>
            </li>
            <%--</sec:authorize>--%>
            <li>
                <a href="<c:url value="/contactUs"/>">
                    <div>
                        Contact us
                        <span>Info about developers</span>
                    </div>
                </a>
            </li>
            <li>
                <a href="<c:url value=" ../createTask.jsp"/>">
                    <div>
                        Add task
                        <span>Сreate new task</span>
                    </div>
                </a>
            </li>
            <div style="width: 200px; padding: 10px; margin-left: auto;" title="Are you ready to strain your brain? =)">
                <img src="../../../resources/img/creative-brain_converted.png">
            </div>
        </ul>
        <%--<div>--%>
            <%--<h1>Русский | Английский</h1>--%>
        <%--</div>--%>
    </nav>
</header>
