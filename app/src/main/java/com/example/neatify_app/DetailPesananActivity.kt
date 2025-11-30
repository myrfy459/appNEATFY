package com.example.neatify_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.neatify_app.databinding.ActivityDetailPesananBinding

class DetailPesananActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPesananBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPesananBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupListeners()
    }

    private fun setupListeners() {
        // Kembali
        binding.btnBack.setOnClickListener { finish() }

        // Tombol Update Status
        binding.btnUpdateStatus.setOnClickListener {
            // Logika update status ke database
            Toast.makeText(this, "Status Diupdate ke: Menyetrika", Toast.LENGTH_SHORT).show()

            // Contoh: Ganti teks tombol setelah update
            binding.btnUpdateStatus.text = "Selesai"
        }

        // Tombol Chat
        binding.btnHubungi.setOnClickListener {
            Toast.makeText(this, "Membuka WhatsApp...", Toast.LENGTH_SHORT).show()
        }
    }
}