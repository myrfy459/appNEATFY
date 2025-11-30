package com.example.neatify_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.neatify_app.databinding.ActivityProfileUserBinding

class ProfileUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        loadUserData()
        setupClickListeners()
    }

    private fun loadUserData() {
        val session = SessionManager(this)
        val user = session.getUser()

        if (user != null) {
            binding.tvName.text = user.name
            binding.tvEmail.text = user.email
        }
    }

    private fun setupClickListeners() {
        // Back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Account Information
        binding.btnAccountInfo.setOnClickListener {
            // TODO: Navigate to Account Info activity
        }

        // Password & Security
        binding.btnPasswordSecurity.setOnClickListener {
            // TODO: Navigate to Password Security activity
        }

        // Push Notifications
        binding.btnNotifications.setOnClickListener {
            // TODO: Navigate to Notifications settings
        }

        // Your Laundry
        binding.btnYourLaundry.setOnClickListener {
            // TODO: Navigate to Your Laundry activity
        }

        // Terms & Conditions
        binding.btnTerms.setOnClickListener {
            // TODO: Navigate to Terms activity
        }

        // About Us
        binding.btnAboutUs.setOnClickListener {
            // TODO: Navigate to About Us activity
        }

        // Help
        binding.btnhelp.setOnClickListener {
            // TODO: Navigate to Help activity
        }

        // Logout
        binding.btnlogout.setOnClickListener {
            val session = SessionManager(this)
            session.clearSession()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Bottom Navigation
        binding.bottomNavigation.selectedItemId = R.id.nav_profile
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_home -> {
                    // Navigate to Home
                    true
                }
                R.id.nav_notifications -> {
                    // Navigate to Notifications
                    true
                }
                R.id.nav_orders -> {
                    // Navigate to Orders
                    true
                }
                R.id.nav_profile -> {
                    // Already on Profile
                    true
                }
                else -> false
            }
        }
    }
}