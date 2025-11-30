package com.example.neatify_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.neatify_app.databinding.ActivityHasilLaporanBinding

class HasilLaporanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHasilLaporanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilLaporanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Ambil data yang dikirim dari halaman sebelumnya
        val jenisLaporan = intent.getStringExtra("JENIS_LAPORAN")

        // Ubah Judul sesuai jenis
        if (jenisLaporan == "PESANAN") {
            binding.tvReportTitle.text = "LAPORAN TOTAL PESANAN"
        } else {
            binding.tvReportTitle.text = "LAPORAN PENDAPATAN"
        }

        // Tombol Back
        binding.btnBack.setOnClickListener { finish() }

        // Tombol Download
        binding.btnDownloadPdf.setOnClickListener {
            Toast.makeText(this, "Sedang mengunduh PDF...", Toast.LENGTH_LONG).show()
        }
    }
}