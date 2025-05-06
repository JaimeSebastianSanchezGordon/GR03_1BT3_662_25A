document.addEventListener('DOMContentLoaded', function() {

    // Animación de aparición para los emprendimientos
    const emprendimientos = document.querySelectorAll('.emprendimiento');

    emprendimientos.forEach((emprendimiento, index) => {
        setTimeout(() => {
            emprendimiento.style.opacity = '1';
            emprendimiento.style.transform = 'translateY(0)';
        }, 100 * index);

        // Estilos iniciales
        emprendimiento.style.opacity = '0';
        emprendimiento.style.transform = 'translateY(20px)';
        emprendimiento.style.transition = 'all 0.5s ease';
    });

    // FUNCIONALIDAD DEL MODAL (usando tu código como base)
    const btnEmprendimiento = document.querySelector(".botonRegistroEmprendimiento");
    const popRegistroEmprendimiento = document.getElementById("registroEmprendimiento");
    const overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);

    // Abrir modal (versión mejorada de tu código)
    btnEmprendimiento.onclick = function() {
        popRegistroEmprendimiento.classList.add("active");
        overlay.classList.add("active");
        document.body.style.overflow = 'hidden';
    };

    // Cerrar modal haciendo click en el overlay
    overlay.addEventListener('click', function() {
        popRegistroEmprendimiento.classList.remove("active");
        overlay.classList.remove("active");
        document.body.style.overflow = 'auto';
    });

    // Efecto hover mejorado para los emprendimientos
    emprendimientos.forEach(emprendimiento => {
        emprendimiento.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-10px)';
            this.querySelector('.tituloEmprendimiento').style.backgroundColor = '#3498db';
        });

        emprendimiento.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(-5px)';
            this.querySelector('.tituloEmprendimiento').style.backgroundColor = '#2c3e50';
        });
    });

    // Validación básica del formulario
    const form = document.querySelector('.datosRegistro form');
    if (form) {
        form.addEventListener('submit', function(e) {
            const nombre = this.querySelector('input[name="nombre"]');
            const descripcion = this.querySelector('input[name="descripcion"]');

            if (!nombre.value.trim()) {
                e.preventDefault();
                nombre.style.borderColor = '#e74c3c';
                setTimeout(() => nombre.style.borderColor = '#ddd', 2000);
            }

            if (!descripcion.value.trim()) {
                e.preventDefault();
                descripcion.style.borderColor = '#e74c3c';
                setTimeout(() => descripcion.style.borderColor = '#ddd', 2000);
            }
        });
    }
});