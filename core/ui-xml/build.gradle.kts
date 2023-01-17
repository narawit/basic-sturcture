@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("neversitup.android.library")
}

android {
    namespace = "com.neversitup.ui.xml"
}

dependencies {
    api(libs.material)
}