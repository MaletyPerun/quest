function statisticState(value) {
    var element = document.getElementById(value);
    var currentDisplay = element.style.display;

    // Измените значение display
    element.style.display = (currentDisplay === 'block') ? 'none' : 'block';

    // Сохраните состояние в localStorage
    localStorage.setItem('displayState', element.style.display);
}

function restoreState(value) {
    var element = document.getElementById(value);
    var displayState = localStorage.getItem('displayState');

    // Проверьте, есть ли сохраненное состояние
    if (displayState !== null) {
        element.style.display = displayState;
    }
}

// Получаем предыдущее сохраненное состояние блоков из localStorage
function setUpState() {
    var prevState = localStorage.getItem('blockState');
    if (prevState === 'visible') {
        showBlock1();
    } else if (prevState === 'hidden') {
        showBlock2();
    }
}

function resetState() {
    var block1 = document.getElementById("prolog");
    var block2 = document.getElementById("quest-img");
    block1.style.display = "block";
    block2.style.display = "none";
    localStorage.setItem('blockState', 'visible');
}

function toggleBlocksInfo() {
    var block1 = document.getElementById("prolog");
    var block2 = document.getElementById("quest-img");

    // Проверяем видимость блока 1
    if (block1.style.display === "block") {
        // Скрываем блок 1 и показываем блок 2
        block1.style.display = "none";
        block2.style.display = "block";

        // Сохраняем состояние блоков в localStorage
        localStorage.setItem('blockState', 'hidden');
    } else {
        // Показываем блок 1 и скрываем блок 2
        block1.style.display = "block";
        block2.style.display = "none";

        // Сохраняем состояние блоков в localStorage
        localStorage.setItem('blockState', 'visible');
    }
}

function showBlock1() {
    var block1 = document.getElementById("prolog");
    var block2 = document.getElementById("quest-img");

    // Показываем блок 1 и скрываем блок 2
    block1.style.display = "block";
    block2.style.display = "none";

    // Сохраняем состояние блоков в localStorage
    localStorage.setItem('blockState', 'visible');
}

function showBlock2() {
    var block1 = document.getElementById("prolog");
    var block2 = document.getElementById("quest-img");

    // Скрываем блок 1 и показываем блок 2
    block1.style.display = "none";
    block2.style.display = "block";

    // Сохраняем состояние блоков в localStorage
    localStorage.setItem('blockState', 'hidden');
}

