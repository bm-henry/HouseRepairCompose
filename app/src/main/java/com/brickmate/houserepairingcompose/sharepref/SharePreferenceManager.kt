package com.brickmate.houserepairingcompose.sharepref

import android.content.SharedPreferences
import javax.inject.Inject

class SharePreferenceManager @Inject constructor(private val prefs: SharedPreferences) {

    var userTokenCache: String
        get() = prefs.getString(PREF_KEY_TOKEN_CACHE, "") ?: ""
        set(userToken) = prefs.edit().putString(PREF_KEY_TOKEN_CACHE, userToken).apply()

    companion object {
        private const val PREF_KEY_TOKEN_CACHE = "user_token"
    }

}