plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":lib"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = group.toString()
        minSdkVersion(24)
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
