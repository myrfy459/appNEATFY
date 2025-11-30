package com.example.neatify_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.neatify_app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupRoleDropdown()
        setupActionListeners()
    }

    private fun setupRoleDropdown() {
        // 1. Siapkan data pilihan role
        val roles = arrayOf("User", "Admin")

        // 2. Buat Adapter untuk Spinner (Dropdown)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, roles)

        // 3. Pasang adapter ke Spinner di layout
        binding.spinnerRole.adapter = adapter
    }

    private fun setupActionListeners() {
        // Tombol Back
        binding.btnBack.setOnClickListener {
            finish() // Kembali ke halaman sebelumnya
        }

        // Tombol Get Started (Register)
        binding.btnRegisterAction.setOnClickListener {
            val fullName = binding.etFullName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val selectedRole = binding.spinnerRole.selectedItem.toString()

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registering as $selectedRole...", Toast.LENGTH_SHORT).show()

                // Simpan data user
                val session = SessionManager(this)
                session.saveUser(fullName, email)

                // Pindah ke Login atau Home
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Link "Already have an account? Log In"
        binding.tvLoginLink.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Menutup halaman register agar tidak menumpuk
        }
    }
}