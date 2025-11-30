package com.example.neatify_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.neatify_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupActionListeners()
    }

    private fun setupActionListeners() {
        binding.btnBack.setOnClickListener { finish() }

        binding.btnLoginAction.setOnClickListener {
            val inputEmail = binding.etEmail.text.toString()
            val inputPassword = binding.etPassword.text.toString()

            if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Mohon isi Email dan Password", Toast.LENGTH_SHORT).show()
            } else {
                // --- PROSES PENGECEKAN DATA ---
                // 1. Ambil data yang tersimpan di HP
                val sharedPref = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE)
                val savedEmail = sharedPref.getString("SAVED_EMAIL", null)
                val savedPassword = sharedPref.getString("SAVED_PASSWORD", null)
                val savedRole = sharedPref.getString("SAVED_ROLE", "User")
                val savedName = sharedPref.getString("SAVED_NAME", "User")

                // 2. Cek apakah data ada?
                if (savedEmail == null || savedPassword == null) {
                    Toast.makeText(this, "Akun belum terdaftar. Silakan Register dulu.", Toast.LENGTH_LONG).show()
                }
                // 3. Cek apakah Email & Password COCOK?
                else if (inputEmail == savedEmail && inputPassword == savedPassword) {

                    Toast.makeText(this, "Login Berhasil! Halo, $savedName", Toast.LENGTH_SHORT).show()

                    // 4. Arahkan ke Halaman sesuai ROLE
                    if (savedRole == "Admin") {
                        val intent = Intent(this, HomeAdminActivity::class.java)
                        startActivity(intent)
                    } else {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    }

                    // Tutup semua halaman sebelumnya agar tidak bisa back ke login
                    finishAffinity()

                } else {
                    // Jika password salah
                    Toast.makeText(this, "Email atau Password Salah!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.tvForgot.setOnClickListener {
            Toast.makeText(this, "Fitur lupa password belum tersedia", Toast.LENGTH_SHORT).show()
        }

        // Tambahkan logika untuk link Sign Up jika user belum punya akun
        // binding.tvSignUpLink... (jika ada textview link ke register)
    }
}