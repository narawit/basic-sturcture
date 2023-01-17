package com.neversitup.common.extension

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


val templates = listOf(
    "yyyy-MM-dd'T'HH:mm:ssZ",
    "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
    "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
    "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ",
    "yyyy-MM-dd'T'HH:mm:ss'Z'",
    "yyyy-MM-dd'T'HH:mm:ss'Z'"
)

fun String.toDate(isGMT: Boolean = false): Date? {
    templates.forEach { template ->
        val date = this.toDate(template, isGMT)
        if (date != null) {
            return date
        }
    }
    return null
}

fun String.toDate(
    formatPattern: String,
    isGMT: Boolean = false
): Date? {
    val format = SimpleDateFormat(formatPattern, Locale.getDefault())
    if (isGMT) format.timeZone = TimeZone.getTimeZone("GMT")
    return try {
        format.parse(this)
    } catch (e: ParseException) {
        null
    }
}

fun Date.display(
    pattern: String,
    isGMT: Boolean = false,
    locale: Locale = Locale.getDefault()
): String {
    val sdf = SimpleDateFormat(pattern, locale)
    if (isGMT) sdf.timeZone = TimeZone.getTimeZone("GMT")
    return  sdf.format(this)
}