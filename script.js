document.getElementById("entrar").addEventListener("click", function () {
    // Evitar duplos cliques
    document.getElementById("entrar").disabled = true;

    document.getElementById("entrar").innerHTML = "Loading...";
    

    setTimeout(function () {
        window.location.href = "login.html"; 
    }, 3000); 
});

