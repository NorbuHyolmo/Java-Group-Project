// clear all the values
function clearScreen() {
    document.getElementById("result").value = "";
}

// display values
function display(value) {
    document.getElementById("result").value += value;
}


const displayBox = document.querySelector(".display-box");
const calculate = document.querySelector("#calc");

calculate.onclick = () => {
    console.log("hello");
    if(displayBox.value.length > 0) {
        let expression = displayBox.value.replace("x", "*");

        fetch(`calculation?expression=${encodeURIComponent(expression)}`)
            .then(res =>
                res.json()
            ).then(data => {
            displayBox.value = data.output;
        }).catch(e => {
            console.log({"error": e.message})
        });
    }
}
