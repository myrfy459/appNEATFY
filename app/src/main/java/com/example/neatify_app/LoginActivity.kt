package com.example.neatify_app

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

        // Sembunyikan Action Bar bawaan
        supportActionBar?.hide()

        setupActionListeners()
    }

    private fun setupActionListeners() {
        // 1. Aksi Tombol Back (Kiri Atas)
        binding.btnBack.setOnClickListener {
            // Perintah finish() akan menutup halaman Login
            // dan otomatis kembali ke halaman sebelumnya (Welcome)
            finish()
        }

        // 2. Aksi Tombol Log In (Orange)
        binding.btnLoginAction.setOnClickListener {
            // Ambil text dari inputan
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in email and password", Toast.LENGTH_SHORT).show()
            } else {
                // Di sini nanti logika login ke server
                Toast.makeText(this, "Logging in as $email...", Toast.LENGTH_SHORT).show()

                // Jika sukses, pindah ke HomeActivity (Nanti kita buat)
            }
        }

        // 3. Aksi Forgot Password
        binding.tvForgot.setOnClickListener {
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        }
    }
}