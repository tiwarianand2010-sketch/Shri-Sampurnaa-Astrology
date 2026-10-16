package com.example.shrisampurnaastrology.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shrisampurnaastrology.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJanamKundli.setOnClickListener {
            Toast.makeText(this, "जन्म कुंडली मॉड्यूल चालू हो रहा है...", Toast.LENGTH_SHORT).show()
            // Open JanamKundliActivity
        }

        binding.btnPrashnKundli.setOnClickListener {
            Toast.makeText(this, "तत्काल प्रश्न कुंडली मॉड्यूल चालू हो रहा है...", Toast.LENGTH_SHORT).show()
            // Open PrashnKundliActivity
        }

        binding.btnPanchang.setOnClickListener {
            Toast.makeText(this, "दैनिक पंचांग एवं मुहूर्त...", Toast.LENGTH_SHORT).show()
            // Open PanchangActivity
        }
    }
}
