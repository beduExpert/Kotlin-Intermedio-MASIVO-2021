[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 08`](../Readme.md) > `Ejemplo 1`

## Ejemplo 1: Configuración de gradle

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Manifestar la versión de compilación a utilizar.
- Declarar la configuración de los build types.
- Ofuscar el código para reducir el tamaño de la app.

### 2. Requisitos :clipboard:

1. Android Studio instalado en nuestra computadora.
2. Seguir la instrucción específica para esta sesión.

### 3. Desarrollo :computer:

Antes de liberar una aplicación hay una serie de pasos que deben realizarse para obtener un despliegue exitoso. Síguelos a continuación:

1. Abre __Android Studio__ y crea un nuevo proyecto con Activity Vacía (Empty Activity).

2. En este proyecto se tiene que validar que se haya removido el código cuyo único propósito era el de debugging. Es recomendable quitar cualquier _Log_ realizado, especialmente si está imprimiendo valores sensibles que puedan comprometer la seguridad de la app o del cliente.

3. Abriremos el archivo ___build.gradle___ de la carpeta raíz, este archivo define las configuraciones de compilación que se aplican a todos los módulos del proyecto. Aquí definimos los repositorios de donde extraemos nuestras dependencias. Todos los archivos ___build.gradle___ son archivos de configuración para la compilación.

```kotlin
// En este bloque se configuran los repositorios y dependencias de gradle
plugins {
    id 'com.android.application' version '8.0.1' apply false
    id 'com.android.library' version '8.0.1' apply false
    id 'org.jetbrains.kotlin.android' version '1.8.20' apply false
}

// En esta sección puedes configurar dependencias y repositorios para todos los módulos en tu aplicación, incluidos módulos externos
// En esta sección puedes configurar dependencias y repositorios para todos los módulos en tu aplicación, incluidos módulos externos
allprojects{
    
}
```

> Ojo 👀
No cierres este archivo, en un momento volveremos a él.



Adicionalmente, podremos abrir este archivo ___settings.gradle___, cuya misión principal es definir submódulos y declarar un directorio root para otros módulos. A diferencia de los build.gradle, solo podemos tener uno por proyecto.

```groovy
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "solucion" // nombre del directorio root
include ':app' //incluímos el módulo app en el proyecto (si fuera multimodular, abajo incluímos los otros)

```

4.Ahora debe abrise el archivo ___app/build.gradle___, que es un archivo de configuración local (para el módulo donde está contenido). En este caso, define toda la configuración para la compilación de nuestro módulo ___app___. Ejemplificaremos con el _build.gradle_ de un proyecto en blanco.

```groovy
//aplicamos plugins
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    namespace 'org.bedu.solucion'
    compileSdk 33 //nivel de sdk a compilar (no puedes usar features de apis superiores)

     buildFeatures {
        viewBinding true
    }
 
    defaultConfig {
        applicationId "org.bedu.solucion" //identificador único de nuestra app para su publicación
        minSdk 24 // la versión mínima de android para que la app funcione
        targetSdk 33 // la versión con la cual se prueba la app
        versionCode 1 // el número de versión
        versionName "1.0" //nombre de la versión para el público

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    // build types (por defecto release y debug).
    buildTypes {
        release {
            minifyEnabled false  // 
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    // Opciones para la compilación Java
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    // Setear diferentes configuraciones de kotlin
    kotlinOptions {
        jvmTarget = '1.8' // La versión de la JVM para generar el bytecode desde kotlin
    }
}

// bloque de dependencias
dependencies {

    implementation 'androidx.core:core-ktx:1.8.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}
```

<!-- Vamos a declarar algunas de las versiones en el ___build.gradle___ raíz, esto para que cada módulo pueda tener acceso a él y se eviten inconsistencias por versiones distintas entre módulos

```kotlin
plugins {...}

allprojects {...}

ext {
    minSdk rootProject.ext.minSdkVersion
    targetSdk rootProject.ext.targetSdkVersion

    coreKtxVersion = '1.10.1'
    constraintLayoutVersion = '2.1.4'
    materialVersion = '1.9.0'
    appCompatVersion = '1.6.1'
}
```

Ahora, a sustituir en ___app/build.gradle___

```kotlin
android {
    compileSdk rootProject.ext.compileSdkVersion
  
    buildFeatures {
        viewBinding true
    }

    defaultConfig {
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.compileSdkVersion
 	...
    }
    ...
}

dependencies {
    implementation "androidx.core:core-ktx:${coreKtxVersion}"
    implementation "androidx.appcompat:appcompat:${appCompatVersion}"
    implementation "com.google.android.material:material:${materialVersion}"
    implementation "androidx.constraintlayout:constraintlayout:${minSdkVersion}"
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}
```

En _buildTypes->release_, habilitaremos la ofuscación y depuración del código cambiando el valor de ___minifyEnabled___ y ___shrinkResources___ a _true_. Esto sólo se recomienda antes de liberar la app ya que hace que el proceso de compilación sea más tardado, pero es necesario para garantizar que la aplicación funciona corretamente.

```kotlin
release {
        minifyEnabled true
        shrinkResources true
        proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
    }
```




[`Anterior`](../Readme.md) | [`Siguiente`](../Ejemplo-02/Readme.md)




</div>
