package com.example.weekend5homework

import android.provider.BaseColumns

object DatabaseContracts {
    object EmployeeEntry : BaseColumns {
        const val TABLE_NAME = "EMPLOYEES_TABLE"
        const val COLUMN_NAME_FIRSTNAME = "first_name"
        const val COLUMN_NAME_LASTNAME = "last_name"
        const val COLUMN_NAME_ADDRESS = "address"
        const val COLUMN_NAME_CITY = "city"
        const val COLUMN_NAME_STATE = "state"
        const val COLUMN_NAME_ZIP = "zip"
        const val COLUMN_NAME_TAXID = "tax_id"
        const val COLUMN_NAME_POSITION = "position"
        const val COLUMN_NAME_DEPARTMENT = "department"
    }

   /* private const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${EmployeeEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${EmployeeEntry.COLUMN_NAME_FIRSTNAME} TEXT," +
                "${EmployeeEntry.COLUMN_NAME_LASTNAME} TEXT," +
                "${EmployeeEntry.COLUMN_NAME_ADDRESS} TEXT," +
                "${EmployeeEntry.COLUMN_NAME_CITY} TEXT," +
                "${EmployeeEntry.COLUMN_NAME_STATE} TEXT," +
                "${EmployeeEntry.COLUMN_NAME_ZIP} TEXT," +
                "${EmployeeEntry.COLUMN_NAME_TAXID} TEXT," +
                "${EmployeeEntry.COLUMN_NAME_POSITION} TEXT," +
                "${EmployeeEntry.COLUMN_NAME_LASTNAME} TEXT," +
                "${EmployeeEntry.COLUMN_NAME_DEPARTMENT} TEXT,)"
*/

    private const val SQL_DELETE_ENTRIES = "DROP ENTRIES IF EXISTS ${EmployeeEntry.TABLE_NAME}"
}