<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
<%--    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
    <script src="<c:url value="/WEB-INF/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="init">Hello Servlet</a>
<a href="quest">Start</a>
<p>${message.getText()}</p>


<%--модальное окно приветствия--%>

<%--модальное окно проигрыша--%>

<%--модальное окно победы--%>

<%--модальное окно квеста--%>
<%--    картинка--%>
<%--    вопрос--%>
<div class="main-window">
    <span><${messages.get(0).getText()}></span>
</div>
<%--    блок вопросов--%>
<div class="answers-block">
    <div class="answer1">
        <button onclick="window.location='/quest?button=1'">${button1}</button>
    </div>
    <div class="answer2">
        <button onclick="window.location='/quest?button=2'">${button2}</button>
    </div>
</div>

<%--модальное окно статистики--%>

<%--модальное окно рестарта--%>
<div class="restart" style="visibility: ${restart}">
    <a href="init" style="visibility: ${restart}">restart</a>
</div>

</body>
</html>