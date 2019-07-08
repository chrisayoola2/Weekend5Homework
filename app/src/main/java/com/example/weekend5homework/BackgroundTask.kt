package com.example.weekend5homework

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager

class BackgroundTask(context: Context) : AsyncTask<String, Void, Void>() {
    var context : Context = context

    fun BackgroundTask(context: Context){
        this.context = context
    }

    //Create BackgroundTask Constructor

    override fun onPreExecute() {
        super.onPreExecute()

    }

    override fun doInBackground(vararg p0: String): Void? { //removed ? from String
        var method : String? = p0[0]
        val employeeDbHelper = EmployeeDbHelper(context)



        if (method.equals("add employee")){
            var first = p0[1]
            var last = p0[2]
            var address = p0[3]
            var city = p0[4]
            var state = p0[5]
            var zip = p0[6]
            var tax = p0[7]
            var position = p0[8]
            var department = p0[9]

           var employee = Employee(first, last , address , city, state, zip, tax, position, department)
            employeeDbHelper.insertEmployee(employee)

            Log.d("TAG","$first, $last, $address, $city, $state, $zip , $tax, $position, $department" )
            // Toast.makeText(context,"$first Inserted Successfully",Toast.LENGTH_LONG).show()
        }

        if (method.equals("filter employee")){
            var department = p0[1]



        }

        if (method.equals("delete employee")){

        }
        return null
    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)

        // Toast.makeText(context,"$first Inserted Successfully",Toast.LENGTH_LONG).show()
    }
}