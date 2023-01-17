@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("neversitup.android.library")
}

android {
    namespace = "com.neversitup.datastore"
}

dependencies {
    implementation(project(":core:common"))
    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)
}
