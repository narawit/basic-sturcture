package com.neversitup.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppDataStore(private val context: Context, name: String) {
    companion object{
        const val AccessToken = "AccessToken"
        const val RefreshToken = "RefreshToken"
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = name)

    fun getInt(key: String): Flow<Int?> {
        val preferenceKey = intPreferencesKey(key)
        return context.dataStore.data.map { pref -> pref[preferenceKey] }
    }

    suspend fun setData(key: String, value: Int) {
        context.dataStore.edit { settings ->
            val preferenceKey = intPreferencesKey(key)
            settings[preferenceKey] = value
        }
    }

    fun getDouble(key: String): Flow<Double?> {
        val preferenceKey = doublePreferencesKey(key)
        return context.dataStore.data.map { pref -> pref[preferenceKey] }
    }

    suspend fun setData(key: String, value: Double) {
        context.dataStore.edit { settings ->
            val preferenceKey = doublePreferencesKey(key)
            settings[preferenceKey] = value
        }
    }

    fun getFloat(key: String): Flow<Float?> {
        val preferenceKey = floatPreferencesKey(key)
        return context.dataStore.data.map { pref -> pref[preferenceKey] }
    }

    suspend fun setData(key: String, value: Float) {
        context.dataStore.edit { settings ->
            val preferenceKey = floatPreferencesKey(key)
            settings[preferenceKey] = value
        }
    }

    fun getLong(key: String): Flow<Long?> {
        val preferenceKey = longPreferencesKey(key)
        return context.dataStore.data.map { pref -> pref[preferenceKey] }
    }

    suspend fun setData(key: String, value: Long) {
        context.dataStore.edit { settings ->
            val preferenceKey = longPreferencesKey(key)
            settings[preferenceKey] = value
        }
    }

    fun getString(key: String): Flow<String?> {
        val preferenceKey = stringPreferencesKey(key)
        return context.dataStore.data.map { pref -> pref[preferenceKey] }
    }

    suspend fun setData(key: String, value: String) {
        context.dataStore.edit { settings ->
            val preferenceKey = stringPreferencesKey(key)
            settings[preferenceKey] = value
        }
    }

    fun getBoolean(key: String): Flow<Boolean?> {
        val preferenceKey = booleanPreferencesKey(key)
        return context.dataStore.data.map { pref -> pref[preferenceKey] }
    }

    suspend fun setData(key: String, value: Boolean) {
        context.dataStore.edit { settings ->
            val preferenceKey = booleanPreferencesKey(key)
            settings[preferenceKey] = value
        }
    }

    fun getSetString(key: String): Flow<Set<String>?> {
        val preferenceKey = stringSetPreferencesKey(key)
        return context.dataStore.data.map { pref -> pref[preferenceKey] }
    }

    suspend fun setData(key: String, value: Set<String>) {
        context.dataStore.edit { settings ->
            val preferenceKey = stringSetPreferencesKey(key)
            settings[preferenceKey] = value
        }
    }

}