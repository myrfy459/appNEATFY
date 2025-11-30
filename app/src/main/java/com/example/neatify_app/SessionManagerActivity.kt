package com.example.neatify_app

import android.content.Context

class SessionManager(context: Context) {

    private val prefs = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

    // ====== SIMPAN DATA USER =======
    fun saveUser(name: String, email: String) {
        val editor = prefs.edit()
        editor.putString("name", name)
        editor.putString("email", email)
        editor.apply()
    }

    // ====== AMBIL DATA USER ========
    fun getUser(): UserModel? {
        val name = prefs.getString("name", null)
        val email = prefs.getString("email", null)

        return if (name != null && email != null) {
            UserModel(name, email)
        } else {
            null
        }
    }

    // ====== SIMPAN STATUS LOGIN ======
    fun setLoggedIn(value: Boolean) {
        val editor = prefs.edit()
        editor.putBoolean("logged_in", value)
        editor.apply()
    }

    // ====== CEK STATUS LOGIN =======
    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("logged_in", false)
    }

    // ====== LOGOUT =======
    fun clearSession() {
        prefs.edit().clear().apply()
    }
}
