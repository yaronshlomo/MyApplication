plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.pomvom.myapplication1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pomvom.myapplication1"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

  /*  kapt {
        correctErrorTypes = true
    }*/

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.dagger:hilt-android:2.47")
    ksp("com.google.dagger:hilt-android-compiler:2.47")

    val composeBom = platform("androidx.compose:compose-bom:2023.08.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Choose one of the following:
    // Material Design 3
    implementation("androidx.compose.material3:material3")
    // or Material Design 2
    implementation("androidx.compose.material:material")
    // or skip Material Design and build directly on top of foundational components
    implementation("androidx.compose.foundation:foundation")
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation("androidx.compose.ui:ui")

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Optional - Included automatically by material, only add when you need
    // the icons but not the material library (e.g. when using Material3 or a
    // custom design system based on Foundation)
    implementation("androidx.compose.material:material-icons-core")
    // Optional - Add full set of material icons
    implementation("androidx.compose.material:material-icons-extended")
    // Optional - Add window size utils
    implementation("androidx.compose.material3:material3-window-size-class")

    // Optional - Integration with activities
    implementation("androidx.activity:activity-compose:1.8.0-alpha06")
    // Optional - Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    // Optional - Integration with LiveData
    implementation("androidx.compose.runtime:runtime-livedata")
    // Optional - Integration with RxJava
    implementation("androidx.compose.runtime:runtime-rxjava2")

    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.0")

    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp:okhttp:2.7.5")

    implementation("com.squareup.okhttp3:logging-interceptor:4.8.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")


    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.30.1")

    implementation ("com.google.accompanist:accompanist-swiperefresh:0.30.1")

    implementation ("com.google.accompanist:accompanist-permissions:0.26.2-beta")

    implementation ("com.google.accompanist:accompanist-pager:0.27.0")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.27.0")

    implementation ("androidx.navigation:navigation-compose:2.7.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")


    implementation ("androidx.room:room-runtime:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2") // For Kotlin use kapt instead of annotationProcessor

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.room:room-ktx:2.5.2")

    // optional - RxJava support for Room
    implementation ("androidx.room:room-rxjava2:2.5.2")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation ("androidx.room:room-guava:2.5.2")

    // Test helpers
    testImplementation ("androidx.room:room-testing:2.5.2")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}