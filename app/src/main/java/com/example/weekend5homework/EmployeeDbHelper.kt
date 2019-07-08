package com.example.weekend5homework

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class EmployeeDbHelper(context: Context) : SQLiteOpenHelper(context , DATABASE_NAME, null, DATABASE_VERSION){


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

   fun insertEmployee(employee: Employee){ // inserts EMPLOYEE OBJECT INTO ROW
       val theseValues = ContentValues().apply {
           put(DatabaseContracts.EmployeeEntry.COLUMN_NAME_FIRSTNAME, employee.firstName)
           put(DatabaseContracts.EmployeeEntry.COLUMN_NAME_LASTNAME, employee.lastName)
           put(DatabaseContracts.EmployeeEntry.COLUMN_NAME_ADDRESS, employee.address)
           put(DatabaseContracts.EmployeeEntry.COLUMN_NAME_CITY, employee.city)
           put(DatabaseContracts.EmployeeEntry.COLUMN_NAME_STATE, employee.state)
           put(DatabaseContracts.EmployeeEntry.COLUMN_NAME_ZIP, employee.zip)
           put(DatabaseContracts.EmployeeEntry.COLUMN_NAME_POSITION, employee.firstName)
           put(DatabaseContracts.EmployeeEntry.COLUMN_NAME_DEPARTMENT, employee.department)
           put(DatabaseContracts.EmployeeEntry.COLUMN_NAME_TAXID, employee.taxID)
       }

           val myDatabase = this@EmployeeDbHelper.writableDatabase
       val result = myDatabase.insert(DatabaseContracts.EmployeeEntry.TABLE_NAME,null, theseValues )

       Log.d("TAG" ,result.toString())

       }

    fun filterBy(department: String) : ArrayList<Employee> { //find employee, return Employee object
        val filteredEmployees = ArrayList<Employee>()
        val query =
            "SELECT * FROM ${DatabaseContracts.EmployeeEntry.TABLE_NAME} WHERE ${DatabaseContracts.EmployeeEntry.COLUMN_NAME_DEPARTMENT} = \"$department\""
        val myDatabase = this.writableDatabase
        val cursor = myDatabase.rawQuery(query,null)
        with(cursor){
            while (moveToNext()){
            var firstNameFromDB  = cursor.getString(cursor.getColumnIndex(DatabaseContracts.EmployeeEntry.COLUMN_NAME_FIRSTNAME))
            var lastNameFromDB  = cursor.getString(cursor.getColumnIndex(DatabaseContracts.EmployeeEntry.COLUMN_NAME_LASTNAME))
            var addressFromDB  = cursor.getString(cursor.getColumnIndex(DatabaseContracts.EmployeeEntry.COLUMN_NAME_ADDRESS))
            var cityFromDB  = cursor.getString(cursor.getColumnIndex(DatabaseContracts.EmployeeEntry.COLUMN_NAME_CITY))
            var stateFromDB  = cursor.getString(cursor.getColumnIndex(DatabaseContracts.EmployeeEntry.COLUMN_NAME_STATE))
            var zipFromDB  = cursor.getString(cursor.getColumnIndex(DatabaseContracts.EmployeeEntry.COLUMN_NAME_ZIP))
            var positionFromDB  = cursor.getString(cursor.getColumnIndex(DatabaseContracts.EmployeeEntry.COLUMN_NAME_POSITION))
            var departmentFromDB  = cursor.getString(cursor.getColumnIndex(DatabaseContracts.EmployeeEntry.COLUMN_NAME_DEPARTMENT))
            var taxIdFromDB  = cursor.getString(cursor.getColumnIndex(DatabaseContracts.EmployeeEntry.COLUMN_NAME_TAXID))
            filteredEmployees.add(Employee(firstNameFromDB,lastNameFromDB,addressFromDB,cityFromDB,stateFromDB,zipFromDB,taxIdFromDB,positionFromDB,departmentFromDB)) }
            }

            return filteredEmployees
        }

        fun deleteEmployee(taxID : String) : Boolean{
            val myDatabase = this.writableDatabase
            val selection = "${DatabaseContracts.EmployeeEntry.TABLE_NAME} LIKE ?"
            val selectionArgs = arrayOf(taxID)

            myDatabase.delete(DatabaseContracts.EmployeeEntry.TABLE_NAME,selection,selectionArgs)
            return true
    }

    //IMPLEMENT UPDATE







    companion object{
        const val DATABASE_NAME = "Employees.db"
        const val DATABASE_VERSION = 1
        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${DatabaseContracts.EmployeeEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${DatabaseContracts.EmployeeEntry.COLUMN_NAME_FIRSTNAME} TEXT," +
                    "${DatabaseContracts.EmployeeEntry.COLUMN_NAME_LASTNAME} TEXT," +
                    "${DatabaseContracts.EmployeeEntry.COLUMN_NAME_ADDRESS} TEXT," +
                    "${DatabaseContracts.EmployeeEntry.COLUMN_NAME_CITY} TEXT," +
                    "${DatabaseContracts.EmployeeEntry.COLUMN_NAME_STATE} TEXT," +
                    "${DatabaseContracts.EmployeeEntry.COLUMN_NAME_ZIP} TEXT," +
                    "${DatabaseContracts.EmployeeEntry.COLUMN_NAME_TAXID} TEXT," +
                    "${DatabaseContracts.EmployeeEntry.COLUMN_NAME_POSITION} TEXT," +
                    "${DatabaseContracts.EmployeeEntry.COLUMN_NAME_DEPARTMENT} TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DatabaseContracts.EmployeeEntry.TABLE_NAME  //check this
    }
}





