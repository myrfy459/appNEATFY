package com.example.neatify_app

import android.content.Context
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
        val roles = arrayOf("User", "Admin")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, roles)
        binding.spinnerRole.adapter = adapter
    }

    private fun setupActionListeners() {
        binding.btnBack.setOnClickListener { finish() }

        binding.btnRegisterAction.setOnClickListener {
            val fullName = binding.etFullName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val selectedRole = binding.spinnerRole.selectedItem.toString()

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Mohon isi semua data", Toast.LENGTH_SHORT).show()
            } else {
                // --- PROSES MENYIMPAN DATA (SIMULASI DATABASE) ---
                val sharedPref = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                // Kita simpan data dengan "Kunci" (Key) agar bisa diambil nanti
                editor.putString("SAVED_EMAIL", email)
                editor.putString("SAVED_PASSWORD", password)
                editor.putString("SAVED_NAME", fullName)
                editor.putString("SAVED_ROLE", selectedRole)
                editor.apply() // Simpan perubahan

                Toast.makeText(this, "Registrasi Berhasil! Silakan Login.", Toast.LENGTH_SHORT).show()

                // Setelah berhasil daftar, arahkan ke halaman LOGIN
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Tutup halaman register
            }
        }

        binding.tvLoginLink.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}