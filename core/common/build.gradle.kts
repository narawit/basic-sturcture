@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("neversitup.android.library")
}

android {
    namespace = "com.neversitup.common"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.viewModel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
}