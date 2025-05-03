document.addEventListener('DOMContentLoaded', function() {
    // Animación de aparición para los eventos
    const eventos = document.querySelectorAll('.evento');

    eventos.forEach((evento, index) => {
        setTimeout(() => {
            evento.style.opacity = '1';
            evento.style.transform = 'translateY(0)';
        }, 100 * index);

        // Estilos iniciales
        evento.style.opacity = '0';
        evento.style.transform = 'translateY(20px)';
        evento.style.transition = 'all 0.5s ease';
    });

    // Funcionalidad del modal
    const btnEvento = document.querySelector(".botonRegistroEvento");
    const popRegistroEvento = document.getElementById("registroEvento");
    const overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);

    // Abrir modal
    btnEvento.addEventListener('click', function() {
        popRegistroEvento.classList.add("active");
        overlay.classList.add("active");
        document.body.style.overflow = 'hidden';
    });

    // Cerrar modal haciendo click en el overlay
    overlay.addEventListener('click', function() {
        popRegistroEvento.classList.remove("active");
        overlay.classList.remove("active");
        document.body.style.overflow = 'auto';
    });

    // Efecto hover mejorado para los eventos
    eventos.forEach(evento => {
        evento.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-10px)';
            this.querySelector('.nombreEvento').style.backgroundColor = '#516591';
        });

        evento.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(-5px)';
            this.querySelector('.nombreEvento').style.backgroundColor = '#448B93';
        });
    });

    // Validación básica del formulario
    const form = document.querySelector('.datosRegistro form');
    if (form) {
        form.addEventListener('submit', function(e) {
            const nombre = this.querySelector('input[name="nombre"]');
            const descripcion = this.querySelector('input[name="descripcion"]');
            const fecha = this.querySelector('input[name="fecha"]');

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

            if (!fecha.value.trim()) {
                e.preventDefault();
                fecha.style.borderColor = '#e74c3c';
                setTimeout(() => fecha.style.borderColor = '#ddd', 2000);
            }
        });
    }
});