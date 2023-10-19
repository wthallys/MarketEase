const cpfInput = document.getElementById("cpf");
const loginButton = document.getElementById("loginButton");
const message = document.getElementById("message");

loginButton.addEventListener("click", () => {
    const cpf = cpfInput.value;

    // Verificar se cpf é valido ou não
    
    message.style.display = "block";

    setTimeout(function () {
        window.location.href = "sistema.html"; 
    }, 1500); 
});