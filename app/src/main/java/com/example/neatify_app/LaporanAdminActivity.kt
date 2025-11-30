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

        // 1. Tangkap Data dari Halaman Sebelumnya
        val jenisLaporan = intent.getStringExtra("JENIS_LAPORAN") ?: "PENDAPATAN"

        // 2. Setup Tampilan Berdasarkan Jenisnya
        setupReportView(jenisLaporan)

        // 3. Tombol Back & Download
        binding.btnBack.setOnClickListener { finish() }
        binding.btnDownloadPdf.setOnClickListener {
            Toast.makeText(this, "Mengunduh Laporan $jenisLaporan...", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupReportView(jenis: String) {
        if (jenis == "PESANAN") {
            // --- TAMPILAN UNTUK LAPORAN PESANAN ---
            binding.tvReportTitle.text = "LAPORAN TOTAL PESANAN"

            // Ubah Header Kolom 3 jadi "Layanan" atau "Status"
            binding.tvHeaderColumn3.text = "Layanan"

            // Ubah Total Bawah jadi Jumlah Order
            binding.tvLabelTotal.text = "TOTAL ORDER"
            binding.tvValueTotal.text = "150 Transaksi"

            // (Optional) Di sini kamu bisa ubah isi tabel dummy secara manual
            // Contoh: Mengubah teks dummy biar kelihatan beda
            // binding.tvRow1Col3.text = "Cuci Komplit"
            // Tapi karena dummy di XML susah diubah satu-satu tanpa ID,
            // biarkan dulu atau gunakan RecyclerView nanti.

        } else {
            // --- TAMPILAN UNTUK LAPORAN PENDAPATAN (Default) ---
            binding.tvReportTitle.text = "LAPORAN PENDAPATAN"

            // Header Kolom 3 Tetap "Jumlah" (Uang)
            binding.tvHeaderColumn3.text = "Pendapatan"

            // Total Bawah Tetap Rupiah
            binding.tvLabelTotal.text = "TOTAL BERSIH"
            binding.tvValueTotal.text = "Rp. 7.500.000"
        }
    }
}