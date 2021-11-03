plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":lib"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")

    implementation("androidx.compose.ui:ui:1.0.4")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.0.4")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.0.4")
    // Material Design
    implementation("androidx.compose.material:material:1.0.4")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.0.4")
    implementation("androidx.compose.material:material-icons-extended:1.0.4")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:1.0.4")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.0.4")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.4")

}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = group.toString()
        minSdkVersion(31)
        targetSdkVersion(31)
        versionCode = 1
        versionName = version.toString()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
    }
}
