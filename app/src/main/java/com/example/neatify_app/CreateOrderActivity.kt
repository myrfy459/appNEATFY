package com.example.neatify_app

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.neatify_app.databinding.ActivityCreateOrderBinding
import java.text.SimpleDateFormat
import java.util.*

class CreateOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateOrderBinding
    private var selectedServiceType: String = "Reguler" // Default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupListeners()
        updateServiceTypeStyle() // Atur gaya awal untuk Reguler
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener { finish() }

        // Pilih Jenis Layanan
        binding.btnServiceReguler.setOnClickListener {
            selectedServiceType = "Reguler"
            updateServiceTypeStyle()
            // Di sini kamu bisa update harga/estimasi sesuai layanan
        }

        binding.btnServiceExpress.setOnClickListener {
            selectedServiceType = "Express"
            updateServiceTypeStyle()
            // Di sini kamu bisa update harga/estimasi sesuai layanan
        }

        // Pilih Tanggal
        binding.etDate.setOnClickListener { showDatePicker() }

        // Pilih Waktu
        binding.etTime.setOnClickListener { showTimePicker() }

        // Tombol Pesan Sekarang
        binding.btnPlaceOrder.setOnClickListener {
            val quantity = binding.etQuantity.text.toString()
            val address = binding.etAddress.text.toString()
            val date = binding.etDate.text.toString()
            val time = binding.etTime.text.toString()

            if (quantity.isEmpty() || address.isEmpty() || date.isEmpty() || time.isEmpty()) {
                Toast.makeText(this, "Mohon lengkapi semua data pesanan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pesanan Berhasil Dibuat! (Service: $selectedServiceType)", Toast.LENGTH_LONG).show()
                // Lanjutkan ke halaman konfirmasi atau kirim data ke server
            }
        }
    }

    private fun updateServiceTypeStyle() {
        // Reset semua
        resetServiceTypeTab(binding.btnServiceReguler)
        resetServiceTypeTab(binding.btnServiceExpress)

        // Set yang aktif
        when (selectedServiceType) {
            "Reguler" -> setActiveServiceTypeTab(binding.btnServiceReguler)
            "Express" -> setActiveServiceTypeTab(binding.btnServiceExpress)
        }
    }

    private fun setActiveServiceTypeTab(tab: TextView) {
        tab.setBackgroundResource(R.drawable.bg_tab_active)
        tab.background.setTint(ContextCompat.getColor(this, R.color.neatify_blue))
        tab.setTextColor(ContextCompat.getColor(this, R.color.white))
    }

    private fun resetServiceTypeTab(tab: TextView) {
        tab.setBackgroundResource(R.drawable.bg_tab_inactive)
        tab.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.etDate.setText(selectedDate)
            }, year, month, day)
        datePickerDialog.show()
    }

    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this,
            { _, selectedHour, selectedMinute ->
                val selectedTime = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute)
                binding.etTime.setText(selectedTime)
            }, hour, minute, true) // true for 24-hour format
        timePickerDialog.show()
    }
}