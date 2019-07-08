package com.example.weekend5homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_filter_employee.*
import kotlinx.android.synthetic.main.fragment_add__employee_.*

class FilterEmployeeActivity : AppCompatActivity() {
    //Spinner is in this class
    lateinit var departmentOptions: Spinner
    lateinit var selected: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_employee)
        departmentOptions = findViewById(R.id.spnrDepartment) as Spinner
        selected = findViewById(R.id.tvChosen) as TextView

        var options =
            arrayOf("Select Database", "Design", "Service", "Engine Assemply  ", "Suspension")// spinner options array
        departmentOptions.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_expandable_list_item_1,
            options
        ) // array to spinner options

        // on item click


        departmentOptions.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selected.text = options.get(p2)

            }

        }


        // Get Spinner Data
    }

    fun onClick(view : View) =
        when(view.id) {
            R.id.btnSubmitFilter -> {
               val backgroundTask = BackgroundTask(this)
                backgroundTask.execute("filter employee", selected.text.toString() )
                val intent = Intent(this,EmployeeListActivity::class.java)
                startActivity(intent)
            }
            else -> {}
        }




}
