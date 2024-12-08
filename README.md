# Explicación Técnica de las Decisiones Tomadas en el Código

## MainActivity.kt

### Descripción:
`MainActivity` es la actividad principal de la aplicación, que sirve como punto de entrada. Aquí se configura el contenido de la interfaz de usuario y se establece el tema de la aplicación utilizando `BattleNetTheme`.

### Decisiones Técnicas:
- Se utiliza `setContent` para establecer el contenido de la actividad de forma declarativa, utilizando Jetpack Compose.
- El `MainScreen()` se coloca dentro de `BattleNetTheme` para asegurar que toda la interfaz siga el estilo de la aplicación.
- El tema es gestionado dentro de la función `BattleNetTheme`, lo cual facilita la personalización y extensión del estilo a nivel global.

---

## Header.kt

### Descripción:
`Header` es un composable que muestra el encabezado de la pantalla de inicio de sesión. Incluye el logo de la aplicación y el nombre "Battle.net".

### Decisiones Técnicas:
- Se utiliza un `Column` para organizar verticalmente el logo y el texto.
- El logo se carga con `Image`, centrado horizontalmente usando `Modifier.align(Alignment.CenterHorizontally)`.
- El texto se establece con `Text` y se aplica un tamaño de fuente grande (`fontSize = 24.sp`), asegurando que sea legible y destacado en la parte superior de la pantalla.

---

## Body.kt

### Descripción:
`Body` es un composable que contiene el formulario de inicio de sesión. Incluye un campo para el correo electrónico, un campo para la contraseña y un botón de inicio de sesión.

### Decisiones Técnicas:
- El `Column` se usa para organizar los campos de texto y el botón en una disposición vertical.
- Se utilizan `TextField` para los campos de correo electrónico y contraseña, permitiendo la entrada de texto por parte del usuario.
- El `Button` es el elemento interactivo para enviar los datos del formulario, y el botón está deshabilitado hasta que los campos de correo y contraseña sean válidos.
- La validación y habilitación del botón se maneja de forma reactiva a través del estado de la interfaz de usuario.

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

## LoginViewModel.kt

### Descripción:
`LoginViewModel` es la clase encargada de gestionar la lógica de la vista de inicio de sesión. Se encarga de la validación del formulario y la lógica de autenticación.

### Decisiones Técnicas:
- Se utiliza `mutableStateOf` para gestionar los estados de los campos de correo electrónico y contraseña, así como el estado de error.
- La validación de los campos de texto se realiza dentro del `ViewModel`, y los resultados de la validación se reflejan automáticamente en la interfaz de usuario.
- Se maneja la lógica de autenticación a través de un método `authenticate`, que verifica si los datos proporcionados coinciden con las credenciales de usuario.
- La comunicación entre la vista y el `ViewModel` se realiza a través de `state` y `events`, siguiendo el patrón de arquitectura recomendada en Jetpack Compose.

---

## LoginScreen.kt

### Descripción:
`LoginScreen` es el composable que representa la pantalla de inicio de sesión. Contiene el formulario con los campos de correo electrónico y contraseña, y el botón para iniciar sesión.

### Decisiones Técnicas:
- La pantalla está organizada en un `Column` que contiene el encabezado (`Header`), el formulario (`Body`) y el pie de página (`Footer`).
- El `ViewModel` es utilizado para manejar la lógica de validación y autenticación, y se observa para reflejar el estado de la UI.
- Los campos de texto (`TextField`) están vinculados a los estados del `ViewModel` para la actualización reactiva de la interfaz.
- El botón de inicio de sesión solo se habilita si ambos campos de texto contienen datos válidos.
- La pantalla sigue un diseño simple y claro, asegurando que el usuario se concentre en ingresar sus credenciales.

---

## Decisiones Generales

### Uso de Jetpack Compose:
- **Modularidad**: Se ha dividido la interfaz en componentes modulares (composables) como `Header`, `Body`, `Footer`, y `LoginScreen`, lo que facilita la reutilización y las pruebas unitarias de cada componente.
- **Interactividad**: El uso de `Modifier.clickable` permite que los textos actúen como enlaces, abriendo URLs mediante `Intent`, lo que facilita la navegación entre recursos externos.
- **Diseño responsivo**: Los `Modifiers` y las funciones como `fillMaxSize` y `padding` aseguran que la interfaz sea responsiva y se ajuste correctamente a diferentes tamaños de pantalla.

---
