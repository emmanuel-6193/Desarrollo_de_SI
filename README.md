Markdown

# Help Desk - Sistema de Gestión de Incidentes (UI Kit)

Esta biblioteca de componentes ha sido diseñada de forma modular bajo estándares modernos de desarrollo web, utilizando **Variables CSS (Custom Properties)**, el **Modelo de Cajas (`border-box`)** y **Layouts Flexbox** para garantizar la consistencia visual, la accesibilidad y la adaptabilidad del sistema.

---

## 🚀 1. Instalación e Integración

Para utilizar este sistema de diseño en cualquier nueva página web de la plataforma, asegúrate de cumplir con la siguiente estructura de archivos:

```text
├── index.html
└── style.css
```
Vincula la hoja de estilos dentro de la etiqueta <head> de tu archivo HTML:
HTML
```
<link rel="stylesheet" href="style.css">
```
2. Cómo reutilizar los Componentes UI
A. Botones (Con Interacciones Activas)
Los botones utilizan una clase base estructural (.btn) y clases modificadoras cromáticas. Cuentan con transiciones suaves para estados :hover y un anillo de enfoque personalizado (:focus) para cumplir con estándares de accesibilidad por teclado.
HTML
```
<button class="btn btn-primary">Botón Primario</button>
<button class="btn btn-secondary">Botón Secundario</button>
<button class="btn btn-danger">Botón de Peligro</button>
```
B. Elementos de Formulario
Diseñados con una disposición vertical automatizada empleando Flexbox (flex-direction: column). Soportan cajas de texto y menús desplegables (select) adaptándose al 100% del contenedor padre.
HTML
```
<div class="form-group">
    <label class="form-label" for="txt-ejemplo">Título del Incidente:</label>
    <input class="form-control" type="text" id="txt-ejemplo" placeholder="Ej. Falla de conexión...">
</div>

<div class="form-group">
    <label class="form-label" for="select-ejemplo">Categoría de Soporte:</label>
    <select class="form-control" id="select-ejemplo">
        <option value="red">Redes y Conectividad</option>
        <option value="software">Desarrollo de Software</option>
    </select>
</div>
```
C. Etiquetas de Prioridad (Badges)
Etiquetas compactas estilo píldora (border-radius-badge: 20px) pensadas para categorizar de forma visual y rápida la severidad de los tickets.
HTML
```
<span class="badge badge-alta">Prioridad Alta</span>
<span class="badge badge-media">Prioridad Media</span>
<span class="badge badge-baja">Prioridad Baja</span>
```
D. Contenedores Dinámicos (Ticket Cards)
Estructuras modulares complejas (<article>) que organizan metadatos mediante propiedades de distribución como justify-content: space-between. Cuentan con un efecto de profundidad/elevación (box-shadow) y modificadores en el borde superior según el estado del caso.
HTML
```
<article class="ticket-card ticket-alta">
    <div class="ticket-card-header">
        <span class="ticket-id">#004</span>
        <span class="badge badge-alta">Alta</span>
    </div>
    <div class="ticket-card-body">
        <h3>Falla en Base de Datos Principal</h3>
        <p>El Singleton del Gestor de Incidentes está experimentando alta latencia.</p>
    </div>
    <div class="ticket-card-footer">
        <span>Soporte: A. Zambrano</span>
        <span>Hace 5 min</span>
    </div>
</article>
```
3. Personalización y Arquitectura CSS
La paleta cromática, tipografías y sombras están centralizadas en la pseudo-clase :root de style.css. Puedes cambiar por completo la identidad visual del ecosistema modificando los valores asignados a estas variables:
CSS
```
:root {
    /* Paleta Cromática */
    --color-primary: #0f2455;       /* Azul institucional principal */
    --color-primary-hover: #5575ac; /* Estado activo/hover para el azul */
    --color-secondary: #4f5150;     /* Gris neutro complementario */
    
    /* Semántica de Estados */
    --color-danger: #dc3545;        /* Alertas críticas (Alta) */
    --color-warning: #ffc107;       /* Advertencias (Media) */
    --color-success: #28a745;       /* Confirmaciones (Baja) */
    
    /* Estructura y Efectos */
    --border-radius: 8px;           /* Redondeado general */
    --shadow-md: 0 8px 16px rgba(0, 0, 0, 0.16); /* Sombras de elevación */
}
```
