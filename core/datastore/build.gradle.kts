@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("neversitup.android.library")
}

android {
    namespace = "com.neversitup.datastore"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)
}
