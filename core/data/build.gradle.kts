plugins {
    id("neversitup.android.library")
    id("kotlinx-serialization")
}

android {
    namespace = "com.neversitup.data"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(project(":core:database"))
    implementation(project(":core:datastore"))
    implementation(project(":core:network"))
    implementation(project(":core:model"))
}