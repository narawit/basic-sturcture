package com.neversitup.convention

@Suppress("EnumEntryName")
enum class Flavor(val dimension: FlavorDimension, val applicationIdSuffix: String? = null) {
    develop(FlavorDimension.contentType,".dev"),
    production(FlavorDimension.contentType)
}