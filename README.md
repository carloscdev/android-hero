# Heros Android

Aplicación Android para crear y visualizar superhéroes personalizados. Permite tomar una foto, ingresar nombre, alter ego, biografía y calificar el poder del héroe.

## Estructura del Proyecto

- `app/src/main/java/com/carloscdev/heros_android/`
  - `MainActivity.java`: Pantalla principal para ingresar datos y tomar foto.
  - `DetailActivity.java`: Muestra los detalles del superhéroe creado.
  - `Superhero.java`: Modelo de datos para superhéroes.
- `app/src/main/res/`: Recursos gráficos y layouts.
- `app/build.gradle.kts`: Configuración de compilación de la app.
- Archivos de configuración: `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, etc.

## Requisitos

- Android Studio Hedgehog o superior
- JDK 11
- Android SDK 35 (compileSdk y targetSdk)
- Mínimo SDK 28

## Instalación y Ejecución Local

1. Clona el repositorio:
   ```sh
   git clone <URL-del-repositorio>
   cd Mobile-Projects
   ```

2. Abre el proyecto en Android Studio.

3. Sincroniza el proyecto con Gradle (Android Studio lo hace automáticamente).

4. Conecta un dispositivo o usa un emulador.

5. Haz clic en "Run" para compilar y ejecutar la app.

## Dependencias principales

- AndroidX AppCompat
- Material Components
- ConstraintLayout
- ViewBinding y DataBinding

## ¿Qué hace la app?

Permite crear un superhéroe ingresando nombre, alter ego, biografía, calificación de poder y tomar una foto. Al guardar, se muestra una pantalla de detalle con la información y la imagen.
