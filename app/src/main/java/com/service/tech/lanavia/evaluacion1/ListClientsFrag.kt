package com.service.tech.lanavia.evaluacion1



import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


class ListClientsFrag() : Fragment() {

    var mycontext:Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //get the context of his parent
        val context:Context = inflater.getContext();


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_clients, container, false)
        //I initialized the RecyclerVie
        var rcvListClients = view.findViewById(R.id.rcvListClients) as RecyclerView

        rcvListClients.layoutManager = LinearLayoutManager(context)

        mycontext=context

        var testClients:MainActivity = context as MainActivity

        //create the respective adapter
        rcvListClients.adapter = ListClientsAdapter(testClients.testClients!!, { clientItem : Client -> clientItemClicked(clientItem) } )



        return view
    }




     fun clientItemClicked(clientItem : Client) {
        //println ( "clientItemClicked" + clientItem.name)
        Toast.makeText(mycontext, "Clicked: ${clientItem.name}  ${clientItem.surname}", Toast.LENGTH_LONG).show()

        /*// Launch second activity, pass part ID as string parameter
        val showDetailActivityIntent = Intent(context, AddClient::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, clientItem.id.toString())
        startActivity(showDetailActivityIntent)*/
    }




}

