package com.example.neatify_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.neatify_app.databinding.ActivityHomeAdminBinding

class HomeAdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide() // Sembunyikan header bar
    }
}