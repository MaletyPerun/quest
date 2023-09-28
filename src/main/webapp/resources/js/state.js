function myToggleStyle(value) {
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
