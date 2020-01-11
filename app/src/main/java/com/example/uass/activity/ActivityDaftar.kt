package com.example.uass.activity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uass.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_regis.*

class ActivityDaftar: AppCompatActivity() {
    lateinit var btnregis : Button
    private lateinit  var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regis)
        btnregis = findViewById(R.id.tombol_regis)
        auth = FirebaseAuth.getInstance()
        btnregis.setOnClickListener{
            fungsilogin()
        }
    }

    private fun fungsilogin() {
        if (tvRegisEmail.text.toString().isEmpty()){
            tvRegisEmail.error = "masukkan Email"
            tvRegisEmail.requestFocus()
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(tvRegisEmail.text.toString()).matches()){
            tvRegisEmail.error= "masukkan Email Valid"
            tvRegisEmail.requestFocus()

        }
        if (tvRegisPaswd.text.toString().isEmpty()){
            tvRegisPaswd.error ="masukkan Paswd yang benar"
            tvRegisPaswd.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(tvRegisEmail.text.toString(), tvRegisPaswd.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val  user = auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(baseContext, "Silahkan Cek Email", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this, ActivityLogin::class.java))
                                finish()
                            }
                        }
                } else {
                    Toast.makeText(baseContext, "Ulang Lagi",
                        Toast.LENGTH_SHORT).show()
                        finish()
                }
            }
    }
}
