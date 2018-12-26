package com.service.tech.lanavia.evaluacion1


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add_client.*


class AddClientFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_add_client, container, false)
        val context: Context = inflater.getContext();
        var myDataBase = (context as MainActivity).myDB


        val spnTypeOfService = view.findViewById<View>(R.id.spnAddFragTypeServ) as Spinner
        val btnFragSave = view.findViewById<View>(R.id.btnFragSave)
        val run = view.findViewById<View>(R.id.txtAddFragRun)
        val name = view.findViewById<View>(R.id.txtAddFragName)
        val surname = view.findViewById<View>(R.id.txtAddFragSurname)
        val city = view.findViewById<View>(R.id.txtAddFragCity)
        val address = "lejos"


        // Create an ArrayAdapter for spinner
        val adapter = ArrayAdapter.createFromResource(context,
            R.array.services, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spnTypeOfService.adapter = adapter




        btnFragSave.setOnClickListener {
            Toast.makeText(
                context, "Spinner 1 " + spnTypeOfService.selectedItem,
                Toast.LENGTH_LONG
            ).show()


            myDataBase?.insertar(Client(0,run.toString(),name.toString(),surname.toString(),city.toString(), address, null))

        }

        return  view
    }


}
