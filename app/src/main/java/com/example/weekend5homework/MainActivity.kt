package com.example.weekend5homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*

 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // IMPLEMENT INTENT STARTED AFTER LOADING COMPLETE
       val intent  = Intent(this, FilterEmployeeActivity::class.java)
        startActivity(intent)

//        val intent2  = Intent(this, EmployeeListActivity::class.java)
//        startActivity(intent2)


    }
}
