<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Quest</title>
    <meta charset="UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="resources/css/style.css" rel="stylesheet">
    <script src="/resources/js/state.js"></script>
</head>
<body>

<div class="quest-info">
    <div class="prolog-div" id="prolog" style="display: block">
        <%@ include file='/resources/jsp/modalStart.jsp' %>
    </div>

    <div class="img-block" id="quest-img" style="display: none">
        <img src="/resources/img/UFO.jpeg" alt="UFO">
    </div>

</div>

<div class="main-window">
    <span>${message}</span>
    <div class="answers-block">
        <div class="answer">
            <button onclick="window.location='/quest?button=1'" class="btn btn-primary btn-large"
                    style="visibility: ${button1visibility}">${button1}</button>
        </div>
        <div class="answer">
            <button onclick="window.location='/quest?button=2'" class="btn btn-primary btn-large"
                    style="visibility: ${button2visibility}">${button2}</button>
        </div>
    </div>
</div>

<div class="restart main-window" id="reset-button" style="visibility: visible">
    <a class="btn btn-primary" href="reset" onclick="resetState()">Начать заново</a>
</div>
<div class="main-window">
    <button class="btn btn-primary" onclick="statisticState('statistics')">статистика</button>
    <div>
        <div class="popup btn btn-primary" id="statistics" style="display: none">
            <span>побед = ${winCount}</span>
        </div>
    </div>
</div>

<script>
    window.onload = restoreState('statistics');
    window.onload = setUpState();
</script>

</body>
</html>