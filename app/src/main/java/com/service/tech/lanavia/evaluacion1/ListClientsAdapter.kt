package com.service.tech.lanavia.evaluacion1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_row_list_client.view.*


class ListClientsAdapter (val clientsItemList: ArrayList<Client>, val clickListener: (Client) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_row_list_client, parent, false)
        return ClientViewHolder(view)
    }

    override fun getItemCount(): Int {
       return clientsItemList.size
    }

    override fun onBindViewHolder(rcv: RecyclerView.ViewHolder, position: Int) {
        (rcv as ClientViewHolder).bind(clientsItemList[position])  }

}

class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(client: Client) {
        itemView.row_of_client_name.text = client.name + "-" + client.surname
        itemView.row_of_client_run.text = client.run.toString()
    }
}

/*class ListClientsAdapter( val clients: ArrayList<Client>, val listener: (Client) -> Unit): RecyclerView.Adapter<CustomViewHolder>(){


    override fun onCreateViewHolder(parentGroup: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parentGroup.context)
        val row = layoutInflater.inflate(R.layout.fragment_row_list_client, parentGroup, false)
        return CustomViewHolder(row)
    }

    override fun getItemCount(): Int {
        return clients.size
     }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(clients[p1],listener)
    }


}

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bind(client: Client, listener: (Client) -> Unit) = with(itemView) {
        id_row_of_client.text = client.name
              setOnClickListener { listener(client) }
    }
}

/*

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v){
    init {
        v.setOnClickListener {
            val intent = Intent(v.context, AddClient::class.java)
            v.context.startActivity(intent)
        }
    }

}*/