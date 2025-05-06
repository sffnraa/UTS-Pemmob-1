package com.example.rasanusantara

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rasanusantara.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding  // View Binding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        txtLoginListener()
    }

    private fun txtLoginListener(){
        binding.txVLog.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnDaftar.setOnClickListener{
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPass.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this, "Email Harus Diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(this, "Email Tidak Valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                Toast.makeText(this, "Password Harus Diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 6){
                Toast.makeText(this, "Password Minimal 6 Karakter", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            RegisterFirebase(email, password)
        }
    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Daftar Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

