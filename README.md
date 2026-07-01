# Guía Básica de Uso - UI Kit (Help Desk)

Esta biblioteca de componentes ha sido diseñada de forma modular bajo estándares modernos de desarrollo web, utilizando **Variables CSS**, el **Modelo de Cajas (`border-box`)** y **Flexbox** para garantizar la consistencia visual y la adaptabilidad del sistema.

## 🚀 1. Instalación e Integración
Para utilizar este sistema de diseño en cualquier nueva página web del proyecto, solo debes asegurarte de cumplir con dos pasos:

1. Copiar el archivo `style.css` en la raíz de tu nuevo directorio de trabajo.
2. Vincular la hoja de estilos dentro de la etiqueta `<head>` de tu archivo HTML de la siguiente manera:
```html
<link rel="stylesheet" href="style.css">

Cómo reutilizar los Componentes
A. Botones
Los botones utilizan una clase base estructural (.btn) y clases modificadoras para definir el propósito cromático. Soportan estados interactivos de hover (pasar el mouse) y focus (navegación por teclado).
<button class="btn btn-primary">Botón Primario</button>

<button class="btn btn-secondary">Botón Secundario</button>

<button class="btn btn-danger">Botón de Peligro</button>

Elementos de Formulario
Para garantizar la alineación vertical automática y el espaciado correcto, envuelve cada campo en un contenedor con la clase .form-group.

HTML
<div class="form-group">
    <label class="form-label" for="id-campo">Título del Incidente:</label>
    <input class="form-control" type="text" id="id-campo" placeholder="Escribe aquí...">
</div>

Tarjetas de Tickets (Contenedores Dinámicos)
Las tarjetas de componentes están diseñadas para maquetar incidentes. Para definir el color del borde superior según la severidad del caso, combina la clase base .ticket-card con una de las tres clases modificadoras de estado: .ticket-alta, .ticket-media o .ticket-baja.

HTML
<article class="ticket-card ticket-alta">
    <div class="ticket-card-header">
        <span class="ticket-id">#004</span>
        <span class="badge badge-alta">Alta</span>
    </div>
    <div class="ticket-card-body">
        <h3>Título del Problema</h3>
        <p>Descripción detallada del incidente reportado.</p>
    </div>
    <div class="ticket-card-footer">
        <span>Soporte: Técnico</span>
        <span>Hace 5 min</span>
    </div>
</article>

3. Personalización (Variables Globales)
Si necesitas cambiar la paleta de colores corporativa de la aplicación, basta con abrir el archivo style.css y actualizar los valores hexadecimales centralizados dentro de la pseudo-clase :root:

CSS
:root {
    --color-primary: #0f2455;       /* Color azul principal del sistema */
    --color-primary-hover: #5575ac; /* Estado hover del color principal */
    --color-danger: #dc3545;        /* Color para alertas críticas o prioridad alta */
    --border-radius: 8px;           /* Redondeado general de los componentes */
}
