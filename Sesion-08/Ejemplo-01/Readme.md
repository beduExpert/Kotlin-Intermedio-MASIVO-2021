[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 08`](../Readme.md) > `Ejemplo 1`

## Ejemplo 1: Configuracion de gradle

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Manifestar la versión de compilación a utilizar
- Declarar la configuración de los build types
- Ofuscar el código para reducir el tamaño de la app

### 2. Requisitos :clipboard:

1. Android Studio Instalado en nuestra computadora.
2. Seguir la instrucción específica para esta sesión.

### 3. Desarrollo :computer:

Antes de liberar una aplicación, hay una serie de pasos que se tienen qué realizar para obtener un despliegue exitoso.

1. Abre __Android Studio__ y crea un nuevo proyecto con Activity Vacía (Empty Activity).

2. En el proyecto que estemos abriendo, se tiene qué validar que se hayan removido el código cuyo único propósito era por debugging. Cualquier _Log_ que se haya realizado, es recomendado removerlo, especialmente si está imprimiendo valores sensibles que puedan comprometer la seguridad de la app o del cliente.

3. Abriremos el archivo ___build.gradle___ de la carpeta raíz, este archivo define las configuraciones de compilación que se aplican a todos los módulos del proyecto. Aquí definimos los repositorios de donde extraemos nuestras dependencias. Todos los archivos ___build.gradle___ son archivos de configuración para la compilación.

```kotlin
// En este bloque se configuran los repositorios y dependencias de gradle
buildscript {
    ext.kotlin_version = "1.3.72"
    // Estos son los repositorios donde buscamos y descargamos dependencias
    repositories {
        google()
        jcenter()
    }
    // Dependencias para gradle, como el complemento de android para gradle con el cual se obtienen las instrucciones para construir los módulos de la app
    dependencies {
        classpath "com.android.tools.build:gradle:4.0.0"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

// En esta sección puedes configurar dependencias y repositorios para todos los módulos en tu aplicación, incluídos módulos externos
allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```

En un momento volveremos a este archivo.


4.Ahora toca abrir el archivo ___app/build.gradle___, que es un archivo de configuración local (para el módulo donde está contenido). En este caso, define toda la configuración para la compilación de nuestro módulo ___app___. Ejemplificaremos con el _build.gradle_ de un proyecto en blanco.

```kotlin
//aplicamos plugins
apply plugin: 'com.android.application' //plugin para definir opciones específicas de android
apply plugin: 'kotlin-android' //habilitamos kotlin para android
apply plugin: 'kotlin-android-extensions'

android {
	
    compileSdkVersion 29  //nivel de sdk a compilar (no puedes usar features de apis superiores)
    buildToolsVersion "29.0.3" //version de sdk build tools, compilador y command-line

	// Configuración de todos los Build Variants
    defaultConfig {
        applicationId "org.bedu.listdetailfragment" //identificador único de nuestra app para su publicación
        minSdkVersion 16 // la versión mínima de android para que la app funcione
        targetSdkVersion 29 //la versión con la cual se prueba la app
        versionCode 1 //el número de versión
        versionName "1.0" //nombre de la versión para el público

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    // build types (por defecto release y debug). 
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

// bloque de dependencias
dependencies {
    implementation fileTree(dir: "libs", include: ["*.jar"])
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.3.1'
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.1'
    implementation 'androidx.recyclerview:recyclerview:1.1.0'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'

}
```

Vamos a declarar algunas de las versiones en el ___build.gradle___ raíz, esto para que cada módulo pueda tener acceso a él y evitar inconsistencias por versiones distintas entre módulos

```kotlin
buildscript {...}

allprojects {...}

ext {
    minSdkVersion
    targetSdkVersion
    buildToolsVersion
    compileSdkVersion = 28

    coreKtxVersion="1.3.1"
    appCompatVersion="1.2.0"
    
}
```

Ahora, a sustituir en ___app/build.gradle___

```kotlin
android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion

    defaultConfig {
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.compileSdkVersion
 	...
    }
    ...
}

dependencies {
    ...
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation "androidx.core:core-ktx:${rootProject.ext.coreKtxVersion}"
    implementation "androidx.appcompat:appcompat:${rootProject.ext.appCompatVersion}"
    ...
}
```

En buildTypes->release, habilitaremos la ofuscación de código y la depuración de código cambiando el valor de ___minifyEnabled___ y ___shrinkResources___ a _true_. Esto sólo se recomienda antes de liberar la app ya que hace que el proceso de compilación sea más tardado.

```kotlin
release {
	    shrinkResourses true
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
```




[`Anterior`](../Readme.md) | [`Siguiente`](../Ejemplo-02/Readme.md)




</div>
