package com.example.neatify_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.neatify_app.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    // Inisialisasi View Binding
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup View Binding
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menyembunyikan ActionBar di atas agar full screen seperti desain
        supportActionBar?.hide()

        setupActionListeners()
    }

    private fun setupActionListeners() {
        // 1. Aksi ketika tombol Create Account diklik -> Ke RegisterActivity
        binding.btnCreateAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // 2. Aksi ketika tombol Log In diklik -> Ke LoginActivity (SUDAH DIPERBAIKI)
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}