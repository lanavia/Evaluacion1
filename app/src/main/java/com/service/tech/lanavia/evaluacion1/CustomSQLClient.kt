package com.service.tech.lanavia.evaluacion1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import java.sql.SQLException

class CustomSQLClient(val context: Context,
                      val name: String,
                      val factory: SQLiteDatabase.CursorFactory?,
                      var version: Int):SQLiteOpenHelper(context,name,factory,version) {



    override fun onCreate(db: SQLiteDatabase?) {

        /* Create table Client
                 val run:String,
                 val name:String,
                 val surname:String,
                 val city:String,
                 val address:String,
                 val service:ArrayList<Service>?){}

         */
        val queryClient = "CREATE TABLE Client(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "run String not null, "+
                "name String not null," +
                "surname String not null," +
                "city String," +
                "address String)"
        db?.execSQL(queryClient)

        /* Create table Service
        val id:Int,
              val idParent: Int,
              val idType:Int,
              val description:String,
              val purchaseDate: String,
              val startDate: String,
              val dueDate:String)
        */



    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertar( client: Client){
        try {
            val db = this.writableDatabase
            //otra forma mas de crear elemento clave valor
            var cv = ContentValues()

            //debe llamarse igual que la columna de la tabla creada
            cv.put("run",client.run)
            cv.put("name", client.name)
            cv.put("surname", client.surname)
            cv.put("city",client.city)
            cv.put("address", client.address)


            val resultado = db.insert("Client",null,cv)
            db.close()

            if (resultado ==-1L){
                Toast.makeText(context,"Cliente no agregado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Cliente agregado", Toast.LENGTH_SHORT).show()
            }

        }catch (e:SQLException){
            Toast.makeText(context,"Error al insertar ${e.message}", Toast.LENGTH_SHORT).show()
            Log.e("sqlInsertar", e.message)
        }
    }



    fun listar(): ArrayList<Client> {
        var lista = ArrayList<Client>()
        try {
            val db = this.writableDatabase
            var cursor: Cursor? = null
            cursor = db.rawQuery("select * from Client", null)
            if (cursor.moveToFirst()) {
                do {
                   /* val id = cursor.getInt(0)
                    val run:String = cursor.getString(1).toString()
                    val name = cursor.getString(2).to
                    val surname: String = cursor.getString(3)
                    val city: String = cursor.getString(4)
                    val address: String = cursor.getString(5)*/

                    val client = cursor as Client

                     //client = Client(id,run,name,surname,city,address,null)
                    lista.add(client)
                } while (cursor.moveToNext())

            }
            db.close()
            return lista
        } catch (e: SQLException) {
            Toast.makeText(context, "Error al listar ${e.message}", Toast.LENGTH_SHORT).show()
        }
        return lista

    }

    fun eliminar(id:Int){
        try {
            val db = this.writableDatabase
            val args = arrayOf(id.toString())
            val resultado = db.delete("client", "id=?",args)
            db.close()
            if (resultado==0){
                Toast.makeText(context, "no se pudo eliminar", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "eliminado", Toast.LENGTH_SHORT).show()
            }

        }catch (e:SQLException){
            Toast.makeText(context,"Error al eliminar ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

}
