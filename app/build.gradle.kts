plugins {
    id("neversitup.android.application")
}

android {
    namespace = "com.neversitup.app"

    defaultConfig {
        applicationId = "com.neversitup.app"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        val debug by getting {

        }
        val release by getting {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:network"))
    implementation(project(":core:datastore"))
    implementation(project(":core:database"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
    implementation(project(":core:ui-xml"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.viewModel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
}