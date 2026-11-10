document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('registro-form');
    const loginButton = document.getElementById('login-button');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        if (form.checkValidity()) {
            alert('Inicio de sesión exitoso. Usuario: ' + form.username.value);
            window.location.href = 'index.html';
        } else {
            console.log('Formulario inválido. Por favor, verifica los campos.');
        }
    });
});
