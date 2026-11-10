document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('registro-form');

    function validarEmail(email) {
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return regex.test(email);
    }

    function validarContraseña(password) {
        // Mínimo 8 caracteres
        if (password.length < 8) {
            return false;
        }
        return true;
    }

    function mostrarEstadoCampo(input, isValid) {
        const inputContainer = input.parentElement;
        const validitySpan = inputContainer.querySelector('.input-status');
        if (isValid) {
            validitySpan.textContent = '✔';
            validitySpan.style.color = 'green';
        } else {
            validitySpan.textContent = '✖';
            validitySpan.style.color = 'red';
        }
    }

    form.email.addEventListener('input', function() {
        const isValid = validarEmail(this.value);
        mostrarEstadoCampo(this, isValid);
    });

    form.password.addEventListener('input', function() {
        const isValid = validarContraseña(this.value);
        mostrarEstadoCampo(this, isValid);
    });

    form.confirmarPassword.addEventListener('input', function() {
        const isValid = form.password.value === this.value;
        mostrarEstadoCampo(this, isValid);
    });

    form.addEventListener('submit', function(event) {
        event.preventDefault();
        const email = form.email.value;
        const password = form.password.value;
        const confirmarPassword = form.confirmPassword.value;

        if (!validarEmail(email)) {
            alert('El email no es válido');
            return;
        }

        if (!validarContraseña(password)) {
            alert('La contraseña debe tener al menos 8 caracteres');
            return;
        }

        if (password !== confirmarPassword) {
            alert('Las contraseñas no coinciden');
            return;
        }

        alert('Registro exitoso');
    });
});
