# Explicación Técnica de las Decisiones Tomadas en el Código

## MainActivity.kt

### Descripción:
`MainActivity` es la actividad principal de la aplicación, que sirve como punto de entrada. Aquí se configura el contenido de la interfaz de usuario y se establece el tema de la aplicación utilizando `BattleNetTheme`.

### Decisiones Técnicas:
- Se utiliza `setContent` para establecer el contenido de la actividad de forma declarativa, utilizando Jetpack Compose.
- El `MainScreen()` se coloca dentro de `BattleNetTheme` para asegurar que toda la interfaz siga el estilo de la aplicación.
- El tema es gestionado dentro de la función `BattleNetTheme`, lo cual facilita la personalización y extensión del estilo a nivel global.

---

## MainScreen.kt

### Descripción:
`MainScreen` es el composable que representa la pantalla principal de la aplicación, mostrando dos botones para iniciar sesión o crear una cuenta.

### Decisiones Técnicas:
- Se usa un `Column` para organizar los elementos de la interfaz de manera vertical, asegurando un diseño limpio y sencillo.
- Los botones se colocan dentro de la columna con espacio entre ellos utilizando `Spacer`.
- Se emplea el `Modifier.fillMaxSize()` para que la columna ocupe toda la pantalla y los elementos estén centrados.
- No se maneja la lógica de inicio de sesión o creación de cuenta en este composable, dejando la lógica a los manejadores de clics que serán implementados en otras partes del código.

---

## Footer.kt

### Descripción:
El `Footer` es un composable que se encarga de mostrar un pie de página con enlaces a recursos externos relacionados con la aplicación, como la creación de cuentas y la política de privacidad.

### Decisiones Técnicas:
- Se utiliza un `Column` para organizar los enlaces de manera vertical y centrada.
- Los enlaces son textos clicables (`Modifier.clickable`), lo que permite abrir las URL correspondientes mediante un `Intent`.
- El `Modifier.padding(bottom = 15.dp)` se aplica al `Column` para agregar un margen en la parte inferior, separando el pie de página del resto de la interfaz.
- Cada enlace es un `Text` con un color específico (`Color(0xFF0074E0)`), y se le da un peso de fuente en negrita (`fontWeight = FontWeight.Bold`) para destacarlos visualmente.

---

## Decisiones Generales

### Uso de Jetpack Compose:
- **Modularidad**: Se ha dividido la interfaz en componentes modulares (composables) como `MainScreen` y `Footer`, lo que facilita la reutilización y las pruebas unitarias de cada componente.
- **Interactividad**: El uso de `Modifier.clickable` permite que los textos actúen como enlaces, abriendo URLs mediante `Intent`, lo que facilita la navegación entre recursos externos.
- **Diseño responsivo**: Los `Modifiers` y las funciones como `fillMaxSize` y `padding` aseguran que la interfaz sea responsiva y se ajuste correctamente a diferentes tamaños de pantalla.

### Consideraciones de Navegación:
- Aunque no se manejan explícitamente en los archivos proporcionados, se ha dejado abierta la posibilidad de integrar un sistema de navegación utilizando `NavController` o un enfoque similar en futuras iteraciones para manejar las transiciones entre diferentes pantallas.

### Seguridad y Accesibilidad:
- Si bien el código actual no incluye detalles sobre autenticación o accesibilidad, se recomienda incorporar medidas de seguridad como validación de datos de usuario y opciones de accesibilidad (por ejemplo, etiquetas `contentDescription` en elementos interactivos).

---

## Conclusión:
La estructura del código se organiza de manera clara y sencilla, aprovechando las características de Jetpack Compose para crear interfaces modulares y fácilmente mantenibles. Las decisiones técnicas tomadas permiten un diseño flexible que puede adaptarse y escalar conforme se añadan más funcionalidades o pantallas a la aplicación.

