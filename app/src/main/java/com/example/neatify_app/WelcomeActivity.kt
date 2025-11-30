package com.example.neatify_app // <--- PERBAIKAN 1: Sesuaikan dengan nama project aslimu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
// PERBAIKAN 2: Import binding harus dari package com.example.neatify_app
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
        // Tombol Create Account
        binding.btnCreateAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Tombol Log In
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}