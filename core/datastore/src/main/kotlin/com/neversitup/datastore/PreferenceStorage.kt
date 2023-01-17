package com.neversitup.datastore

import android.content.SharedPreferences

class PreferenceStorage(
    private val prefs: SharedPreferences
) {
    fun getString(
        key: String,
        defaultValue: String
    ): String =
        prefs.getString(key, defaultValue) ?: defaultValue

    fun putString(
        key: String,
        value: String
    ) {
        put(key, value)
    }

    fun getInt(
        key: String,
        defaultValue: Int
    ): Int =
        prefs.getInt(key, defaultValue)

    fun putInt(
        key: String,
        value: Int
    ) {
        put(key, value)
    }

    fun getLong(
        key: String,
        defaultValue: Long
    ): Long =
        prefs.getLong(key, defaultValue)

    fun putLong(
        key: String,
        value: Long
    ) {
        put(key, value)
    }

    fun getFloat(
        key: String,
        defaultValue: Float
    ): Float =
        prefs.getFloat(key, defaultValue)

    fun putFloat(
        key: String,
        value: Float
    ) {
        put(key, value)
    }

    fun getBoolean(
        key: String,
        defaultValue: Boolean
    ): Boolean =
        prefs.getBoolean(key, defaultValue)

    fun putBoolean(
        key: String,
        value: Boolean
    ) {
        put(key, value)
    }

    fun getStringSet(key: String): Set<String>? {
        return prefs.getStringSet(key, HashSet())
    }

    fun putStringSet(
        key: String,
        set: Set<String>
    ) {
        prefs.edit()
            .putStringSet(key, set)
            .apply()
    }

    fun contains(key: String) = prefs.contains(key)

    fun delete(key: String) {
        prefs.edit()
            .remove(key)
            .apply()
    }

    fun deleteAll() {
        prefs.edit()
            .clear()
            .apply()
    }

    private fun <T> put(
        key: String,
        value: T?
    ) {
        try {
            when (value) {
                is Boolean -> {
                    prefs.edit()
                        .putBoolean(key, value)
                        .apply()
                }
                is Int -> {
                    prefs.edit()
                        .putInt(key, value)
                        .apply()
                }
                is Float -> {
                    prefs.edit()
                        .putFloat(key, value)
                        .apply()
                }
                else -> {
                    prefs.edit()
                        .putString(key, value.toString())
                        .apply()
                }
            }

        } catch (_: Exception) {

        }
    }

}