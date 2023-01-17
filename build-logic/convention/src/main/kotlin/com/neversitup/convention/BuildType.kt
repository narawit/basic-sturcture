package com.neversitup.convention

@Suppress("unused")
enum class BuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE
}
