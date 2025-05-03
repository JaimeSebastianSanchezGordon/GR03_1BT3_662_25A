document.addEventListener('DOMContentLoaded', function() {
    // Animación de aparición para los recursos
    const recursos = document.querySelectorAll('.recurso');

    recursos.forEach((recurso, index) => {
        setTimeout(() => {
            recurso.style.opacity = '1';
            recurso.style.transform = 'translateY(0)';
        }, 100 * index);

        // Estilos iniciales
        recurso.style.opacity = '0';
        recurso.style.transform = 'translateY(20px)';
        recurso.style.transition = 'all 0.5s ease';
    });

    // FUNCIONALIDAD DEL MODAL
    const btnRecurso = document.querySelector(".botonRegistroRecurso");
    const popRegistroRecurso = document.getElementById("registroRecurso");
    const overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);

    // Abrir modal
    btnRecurso.onclick = function() {
        popRegistroRecurso.classList.add("active");
        overlay.classList.add("active");
        document.body.style.overflow = 'hidden';
    };

    // Cerrar modal haciendo click en el overlay
    overlay.addEventListener('click', function() {
        popRegistroRecurso.classList.remove("active");
        overlay.classList.remove("active");
        document.body.style.overflow = 'auto';
    });

    // Efecto hover mejorado para los recursos
    recursos.forEach(recurso => {
        recurso.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-10px)';
            this.querySelector('.tipoRecurso').style.backgroundColor = '#3498db';
        });

        recurso.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(-5px)';
            this.querySelector('.tipoRecurso').style.backgroundColor = '#2c3e50';
        });
    });

    // Validación básica del formulario de recursos
    const formRecurso = document.querySelector('.datosRegistro form');
    if (formRecurso) {
        formRecurso.addEventListener('submit', function(e) {
            const tipoRecurso = this.querySelector('input[name="tipoRecurso"]');
            const nombreRecurso = this.querySelector('input[name="nombreRecurso"]');
            const cantidadRecurso = this.querySelector('input[name="cantidadRecurso"]');

            if (!tipoRecurso.value.trim()) {
                e.preventDefault();
                tipoRecurso.style.borderColor = '#e74c3c';
                setTimeout(() => tipoRecurso.style.borderColor = '#ddd', 2000);
            }

            if (!nombreRecurso.value.trim()) {
                e.preventDefault();
                nombreRecurso.style.borderColor = '#e74c3c';
                setTimeout(() => nombreRecurso.style.borderColor = '#ddd', 2000);
            }

            if (!cantidadRecurso.value.trim() || isNaN(cantidadRecurso.value)) {
                e.preventDefault();
                cantidadRecurso.style.borderColor = '#e74c3c';
                setTimeout(() => cantidadRecurso.style.borderColor = '#ddd', 2000);
            }
        });
    }

    // Cerrar modal con la tecla ESC
    document.addEventListener('keydown', function(e) {
        if (e.key === 'Escape') {
            popRegistroRecurso.classList.remove("active");
            overlay.classList.remove("active");
            document.body.style.overflow = 'auto';
        }
    });
});