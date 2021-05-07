var numberBts = new Map();
numberBts.set("bt0", document.querySelector(".bt0"));
numberBts.set("bt1", document.querySelector(".bt1"));
numberBts.set("bt2", document.querySelector(".bt2"));
numberBts.set("bt3", document.querySelector(".bt3"));
numberBts.set("bt4", document.querySelector(".bt4"));
numberBts.set("bt5", document.querySelector(".bt5"));
numberBts.set("bt6", document.querySelector(".bt6"));
numberBts.set("bt7", document.querySelector(".bt7"));
numberBts.set("bt8", document.querySelector(".bt8"));
numberBts.set("bt9", document.querySelector(".bt9"));

var btAdd = document.querySelector(".btAdd");
var btSub = document.querySelector(".btSub");
var btMul = document.querySelector(".btMul");
var btDiv = document.querySelector(".btDiv");

var btReset = document.querySelector(".btReset");
var btPonto = document.querySelector(".btPonto");
var btResut = document.querySelector(".btResut");

var num1 = 0;
var num2 = 0;
var op = null;
var resultado = null;
var concluido = false;
var decimal = false;
var display = document.querySelector(".display");

btAdd.addEventListener("click", () => {
    decimal = false;
    op = "+";
    addDisplay("+");
});
btSub.addEventListener("click", () => {
    decimal = false;
    op = "-";
    addDisplay("-");
});
btMul.addEventListener("click", () => {
    decimal = false;
    op = "*";
    addDisplay("*");
});
btDiv.addEventListener("click", () => {
    decimal = false;
    op = "/";
    addDisplay("/");
});
btPonto.addEventListener("click", () => {
    decimal = false;
    op = "%";
    addDisplay("%");
});

for (let i = 0; i < 10; i++) {
    numberBts.get(`bt${i}`).addEventListener("click", () => {
        addCalc(i);
        addDisplay(i);
    });
}

function addCalc(n) {
    if (concluido) {
        reset();
        concluido = false;
    }

    if (op == null) {
        if (decimal) {
            num1 += +n / 10;
        } else {
            num1 = num1 * 10 + n;
        }
    } else {
        if (decimal) {
            num2 += +n / 10;
        } else {
            num2 = num2 * 10 + n;
        }
    }

    if (num1 == 0 || op == null || num2 == 0) {
        btResut.disabled = true;
    } else {
        btResut.disabled = false;
    }
}

btResut.addEventListener("click", () => {
    switch (op) {
        case "+":
            soma();
            break;
        case "-":
            subtracao();
            break;
        case "/":
            divisao();
            break;
        case "*":
            multiplicacao();
            break;
        case "%":
            resto();
            break;
    }
    concluido = true;
});

function soma() {
    setDisplay(num1 + num2);
}
function subtracao() {
    setDisplay(num1 - num2);
}
function divisao() {
    setDisplay(num1 / num2);
}
function multiplicacao() {
    setDisplay(num1 * num2);
}
function resto() {
    setDisplay(num1 % num2);
}

function addDisplay(n) {
    console.log(display.textContent.length);
    if (display.textContent.length < 12) {
        display.textContent += n;
    }
}

function setDisplay(str) {
    display.textContent = str;
    if (display.textContent <= 12) {
        display.textContent = display.textContent.trim();
    } else {
        display.textContent = display.textContent.substr(0, 11);
    }
}

btReset.addEventListener("click", reset);

function reset() {
    num1 = 0;
    num2 = 0;
    op = null;
    resultado = null;
    display.textContent = "";
    btResut.disabled = true;
    decimal = false;
}
