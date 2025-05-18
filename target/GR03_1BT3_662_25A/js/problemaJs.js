document.addEventListener('DOMContentLoaded', function() {
    // Animation for security cards
    const seguridades = document.querySelectorAll('.seguridad');

    seguridades.forEach((seguridad, index) => {
        setTimeout(() => {
            seguridad.style.opacity = '1';
            seguridad.style.transform = 'translateY(0)';
        }, 100 * index);

        // Initial styles
        seguridad.style.opacity = '0';
        seguridad.style.transform = 'translateY(20px)';
        seguridad.style.transition = 'all 0.5s ease';
    });

    // Modal functionality
    const btnSeguridad = document.querySelector(".botonRegistroSeguridad");
    const popRegistroSeguridad = document.getElementById("registroSeguridad");
    const overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);

    // Open modal
    btnSeguridad.onclick = function() {
        popRegistroSeguridad.classList.add("active");
        overlay.classList.add("active");
        document.body.style.overflow = 'hidden';
    };

    // Close modal when clicking overlay
    overlay.addEventListener('click', function() {
        popRegistroSeguridad.classList.remove("active");
        overlay.classList.remove("active");
        document.body.style.overflow = 'auto';
    });

    // Enhanced hover effect for security cards
    seguridades.forEach(seguridad => {
        seguridad.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-10px)';
            this.querySelector('.tituloSeguridad h3').style.color = '#3498db';
        });

        seguridad.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(-5px)';
            this.querySelector('.tituloSeguridad').style.color = '#2c3e50';
        });
    });

    // Form validation
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

    // Close modal with ESC key
    document.addEventListener('keydown', function(e) {
        if (e.key === 'Escape') {
            popRegistroSeguridad.classList.remove("active");
            overlay.classList.remove("active");
            document.body.style.overflow = 'auto';
        }
    });
});