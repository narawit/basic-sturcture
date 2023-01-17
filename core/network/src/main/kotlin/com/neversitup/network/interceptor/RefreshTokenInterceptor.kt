package com.neversitup.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

//class RefreshTokenInterceptor() : Interceptor {
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val response = chain.proceed(chain.request())
//        if (response.code == 401) {
//            synchronized(this) {
//                return if (!response.request.header("Authorization")
//                        .equals("Bearer ${shared.getString(ConstPreference.PREF_KEY_ACCESS_TOKEN, "")}")
//                ) {
//                    response.close()
//                    getResponse(chain)
//                } else {
//                    response.close()
//                    getRefreshToken()
//                    getResponse(chain)
//                }
//            }
//        } else return response
//    }
//
//    private fun getRefreshToken() {
//        val refreshToken = shared.getString(ConstPreference.PREF_KEY_REFRESH_TOKEN, "")
//        val jwtDataToken = service.callJwtRefreshToken(RefreshTokenRequest(refreshToken))
//            .execute()
//        if (jwtDataToken.isSuccessful) {
//            val body = jwtDataToken.body()?.data
//            body?.refresh_token?.let {
//                shared.putString(ConstPreference.PREF_KEY_REFRESH_TOKEN, it)
//            }
//            body?.access_token?.let {
//                shared.putString(ConstPreference.PREF_KEY_ACCESS_TOKEN, it)
//            }
//            body?.account_id?.let {
//                shared.putInt(ConstPreference.PREF_KEY_USER_ID, it)
//            }
//        }
//    }
//
//    private fun getResponse(chain: Interceptor.Chain): Response {
//        val request = chain.request()
//            .newBuilder()
//            .apply {
//                val token = shared.getString(ConstPreference.PREF_KEY_ACCESS_TOKEN, "")
//                if (token.isNotEmpty())
//                    header("Authorization", "Bearer ${shared.getString(ConstPreference.PREF_KEY_ACCESS_TOKEN, "")}")
//            }
//        return chain.proceed(request.build())
//    }
//}