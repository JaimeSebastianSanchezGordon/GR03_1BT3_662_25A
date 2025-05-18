document.addEventListener('DOMContentLoaded', function() {
    // Selecciona todos los elementos con las clases 'tarjeta-caracteristica' y 'enlace-rapido'
    const elementos = document.querySelectorAll('.tarjeta-caracteristica, .enlace-rapido');

    // Aplica un efecto de aparición gradual a cada elemento
    elementos.forEach((elemento, indice) => {
        setTimeout(() => {
            elemento.style.opacity = '1';          // Hace el elemento visible
            elemento.style.transform = 'translateY(0)'; // Lo mueve a su posición final
        }, 300 * indice); // Retraso basado en el índice para un efecto escalonado

        // Configuración inicial (antes de la animación):
        elemento.style.opacity = '0';             // Inicia invisible
        elemento.style.transform = 'translateY(20px)'; // Empieza 20px más abajo
        elemento.style.transition = 'opacity 0.6s ease, transform 0.7s ease'; // Suaviza la transición
    });
});