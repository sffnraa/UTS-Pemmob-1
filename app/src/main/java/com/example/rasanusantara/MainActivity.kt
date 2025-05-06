package com.example.rasanusantara

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rasanusantara.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding  // View Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnRegisterListener()
        btnLoginListener()

    }

    private fun btnLoginListener(){
        binding.btn1.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun btnRegisterListener(){
        binding.btn2.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}