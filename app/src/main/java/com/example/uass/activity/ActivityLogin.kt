package com.example.uass.activity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uass.MainActivity
import com.example.uass.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class ActivityLogin: AppCompatActivity() {
    lateinit var btnlogin : Button
    lateinit var btndaftar:Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        btndaftar = findViewById(R.id.tombol_register)
        btnlogin = findViewById(R.id.tombol_logi)


        btndaftar.setOnClickListener {
            startActivity(Intent(this, ActivityDaftar::class.java))
            finish()
        }

        btnlogin.setOnClickListener{
           fungsilogin()
        }
    }

    private fun fungsilogin() {
        if (form_email.text.toString().isEmpty()){
            form_email.error = "masukkan Email"
            form_email.requestFocus()
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(form_email.text.toString()).matches()){
            form_email.error= "masukkan Email Valid"
            form_email.requestFocus()

        }
        if (form_passwo.text.toString().isEmpty()){
            form_passwo.error ="masukkan Paswd yang benar"
            form_passwo.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(form_email.text.toString(),form_passwo.text.toString() )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = auth.currentUser
                    updateUI(user)
                } else {

                    updateUI(null)
                }

                // ...
            }
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser:FirebaseUser?) {
        if (currentUser != null){
            if (currentUser.isEmailVerified){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(baseContext, "Email belum Di Verifikasi silahkan cek Email ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }else{
            Toast.makeText(baseContext, "Login failed.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}
