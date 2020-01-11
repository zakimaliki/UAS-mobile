package com.example.uass

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.RecyclerView
import bersatu.kita.part11.Model.Pelajaran
import com.example.uass.activity.ActivitySd
import com.example.uass.activity.ActivitySma
import com.example.uass.activity.ActivitySmp
import com.example.uass.activity.ActivityTk
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var btntk: Button
    private lateinit var btnsd: Button
    private lateinit var btnsmp: Button
    private lateinit var btnsma: Button
    private lateinit var rvHeroes: RecyclerView
    private var title = "Mode List"
    private val list = ArrayList<Pelajaran>()

    private lateinit var appBarConfiguration: AppBarConfiguration

    private var TAG = "data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        fungsibtn()

    }

    private fun fungsibtn() {
        btntk = findViewById(R.id.btnTk)
        btnsd = findViewById(R.id.btnSD)
        btnsmp = findViewById(R.id.btnSMP)
        btnsma = findViewById(R.id.btnSMA)

        btntk.setOnClickListener {
            startActivity(Intent(this, ActivityTk::class.java))
        }

        btnsd.setOnClickListener {
            startActivity(Intent(this, ActivitySd::class.java))
        }
        btnsmp.setOnClickListener {
            startActivity(Intent(this, ActivitySmp::class.java))
        }
        btnsma.setOnClickListener {
            startActivity(Intent(this, ActivitySma::class.java))
        }
    }


//        setSupportActionBar(toolbar)

//        val fab: FloatingActionButton = findViewById(R.id.fab)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
//        val navView: NavigationView = findViewById(R.id.nav_view)
//        val navController = findNavController(R.id.nav_host_fragment)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
//                R.id.nav_tools, R.id.nav_share, R.id.nav_send
//            ), drawerLayout
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()


}
