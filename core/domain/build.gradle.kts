plugins {
    id("neversitup.android.library")
    id("kotlinx-serialization")
    kotlin("kapt")
}

android {
    namespace = "com.neversitup.domain"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(project(":core:data"))
    implementation(project(":core:model"))
}