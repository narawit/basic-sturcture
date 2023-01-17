plugins {
    id("neversitup.android.library")
    id("kotlinx-serialization")
    kotlin("kapt")
}

android {
    namespace = "com.neversitup.domain"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))
}