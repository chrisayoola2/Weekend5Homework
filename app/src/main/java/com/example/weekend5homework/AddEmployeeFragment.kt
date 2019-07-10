package com.example.weekend5homework

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_add__employee_.*
import kotlinx.android.synthetic.main.fragment_add__employee_.view.*
import org.w3c.dom.Text


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AddEmployeeFragment : Fragment(),BackgroundTask.AsyncCallback{
    override fun returnEmployee(employeeArray: ArrayList<Employee>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    lateinit var departmentSpinner: Spinner
    lateinit var picked: TextView // invisible textview
    private lateinit var myView: View

    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_add__employee_, container, false)
        myView = view
        picked = myView.findViewById(R.id.tvtester)

        departmentSpinner = myView.findViewById(R.id.SpinnerAddEmployee) as Spinner
        var options =
            arrayOf("Select Database", "Design", "Service", "Engine Assembly", "Suspension")// spinner options array

        departmentSpinner.adapter =
            ArrayAdapter<String>(myView.context, android.R.layout.simple_expandable_list_item_1, options)

        departmentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                picked.text = p0?.getItemAtPosition(p2).toString()
            }
        }

        myView.btnSubmitEmployee.setOnClickListener {
            val firstName = etfirstName.text.trim().toString()
            val lastName = etLastName.text.trim().toString()
            val address = etAddress.text.trim().toString()
            val city = etCity.text.trim().toString()
            val state = etState.text.trim().toString()
            val zip = etZip.text.trim().toString()
            val taxId = etTax.text.trim().toString()
            val position = etPosition.text.trim().toString()
            val department = picked.text.toString()
           //checks if picker has been used
            if (department.equals("Select Database")){
                Toast.makeText(context,"Please Select a Department!!",Toast.LENGTH_LONG).show()
            }else{

            val backgroundTask = BackgroundTask(myView.context,this)

            backgroundTask.execute("add employee", firstName,lastName,address,city,state,zip, taxId, position,department)
            Log.d("TAG", "$firstName, $department")
            Toast.makeText(context,"$firstName Inserted Successfully",Toast.LENGTH_LONG).show()
            getActivity()!!.supportFragmentManager.beginTransaction().remove(this).commit()
            }

        }
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // val department = picked.text




    }



    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddEmployeeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
