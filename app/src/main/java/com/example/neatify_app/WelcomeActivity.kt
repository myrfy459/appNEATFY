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
        // Aksi ketika tombol Create Account diklik
        binding.btnCreateAccount.setOnClickListener {
            // Arahkan ke halaman RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Aksi ketika tombol Log In diklik
        binding.btnLogin.setOnClickListener {
            Toast.makeText(this, "Menuju halaman Log In...", Toast.LENGTH_SHORT).show()
        }
    }
}