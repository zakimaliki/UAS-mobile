package com.example.uass.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.uass.R

@SuppressLint("Registered")
class ActivitySma: AppCompatActivity() {
    lateinit var tombol1: Button
    lateinit var tombol2: Button
    lateinit var tombol3: Button
    lateinit var tombol4: Button
    lateinit var tombol5: Button
    lateinit var tombol6: Button
    lateinit var tombol7: Button
    lateinit var tombol8: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sma)
        fungsiButton()
        tampilspiner()
    }

    private fun fungsiButton() {
        tombol1 = findViewById(R.id.btn_agama_sma)
        tombol2 = findViewById(R.id.btn_bindo_sma)
        tombol3 = findViewById(R.id.btn_ipa_sma)
        tombol4 = findViewById(R.id.btn_ips_sma)
        tombol5 = findViewById(R.id.btn_mtk_sma)
        tombol6 = findViewById(R.id.btn_penjas_sma)
        tombol7 = findViewById(R.id.btn_pkn_sma)
        tombol8 = findViewById(R.id.btn_tema_sma)


        tombol1.setOnClickListener {
            startActivity(Intent(this, ActivityMataPelajaran::class.java))
            finish()
        }

        tombol2.setOnClickListener {
            startActivity(Intent(this, ActivityMataPelajaran::class.java))
            finish()
        }
        tombol3.setOnClickListener {
            startActivity(Intent(this, ActivityMataPelajaran::class.java))
            finish()
        }
        tombol4.setOnClickListener {
            startActivity(Intent(this, ActivityMataPelajaran::class.java))
        }
        tombol5.setOnClickListener {
            startActivity(Intent(this, ActivityMataPelajaran::class.java))
        }
        tombol6.setOnClickListener {
            startActivity(Intent(this, ActivityMataPelajaran::class.java))
        }
        tombol7.setOnClickListener {
            startActivity(Intent(this, ActivityMataPelajaran::class.java))
        }
        tombol8.setOnClickListener {
            startActivity(Intent(this, ActivityMataPelajaran::class.java))
        }
    }


    private fun tampilspiner() {
        val languages = resources.getStringArray(R.array.Kelas_SMA)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinersma)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@ActivitySma,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

}