package com.service.tech.lanavia.evaluacion1

import android.app.Application
import android.content.Context

class GlobalVariables(): Application() {

    var myDB:CustomSQLClient? = null
    var clients:ArrayList<Client>? = null

    val typeOfService = loadTypeOfService()



     fun loadTypeOfService():ArrayList<TypeOfService>{
         val l = ArrayList<TypeOfService>()

         l.add(TypeOfService(1,"Pc") )
         l.add(TypeOfService(2,"Laptop") )
         l.add(TypeOfService(3,"Celular"))
         l.add(TypeOfService(4,"Tablet"))
         l.add(TypeOfService(5,"Impresora"))

         return l
     }






    fun createTestData():ArrayList<Client>{
        val services1:ArrayList<Service> = arrayListOf(
            Service(1,1,1,"Falla en la pantalla","20181009","20181101", "20181107" ),
            Service(2,1,3,"Gps no funciona","20181024","20181104", "20181112" ),
            Service(3,1,5,"No sale la tinta","20180404","20180801", "20180816" ))

        val services2:ArrayList<Service> = arrayListOf(
            Service(4,2,2,"Falla en el teclado","20180708","20180721", "20180803" ),
            Service(5,2,3,"El touch no funciona","20180120","20181102", "20181110" ))

        val services3:ArrayList<Service> = arrayListOf(
            Service(6,3,2,"No carga el Laptop","20181102","20181117", "20181130" ))


        var clients = arrayListOf<Client>(
            Client(1, "123456789k","Cliente1", "appellido1","Santiago","Balmaceda 123", services1 ),
            Client(2, "9999999999","Cliente2", "appellido2","Santiago","Alameda 444", services2 ),
            Client(3, "1111111111","Cliente3", "appellido3","Concepcion","Irarrazaba 123", services3 ))

        return clients

    }

}

