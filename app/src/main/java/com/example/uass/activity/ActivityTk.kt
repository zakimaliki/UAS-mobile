package com.example.uass.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.uass.R

class ActivityTk: AppCompatActivity() {
    lateinit var btn1:Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tk)

        tampilbtn()
    }

    private fun tampilbtn() {
        btn1 = findViewById(R.id.btn_membaca_tk)
        btn2 = findViewById(R.id.btn_menggambar_tk)
        btn3 = findViewById(R.id.btn_mennyanyi_tk)
        btn4 = findViewById(R.id.btn_menulis_tk)


        btn1.setOnClickListener{
            startActivity(Intent(this,ActivityMataPelajaran::class.java))
        }
        btn2.setOnClickListener{
            startActivity(Intent(this,ActivityMataPelajaran::class.java))
        }
        btn3.setOnClickListener{
            startActivity(Intent(this,ActivityMataPelajaran::class.java))
        }
        btn4.setOnClickListener{
            startActivity(Intent(this,ActivityMataPelajaran::class.java))
        }

    }
}