package com.support.myapplicationmobil.list


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.support.myapplicationmobil.Lugar
import com.support.myapplicationmobil.LugarItem
import com.support.myapplicationmobil.R
import com.support.myapplicationmobil.detalle.DetalleActivity

class ListLugaresActivity : AppCompatActivity() {

    private lateinit var listLugares: ArrayList<LugarItem>
    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var lugaresRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)

        //Buscar un recurso por el id
        lugaresRecyclerView = findViewById(R.id.Lugares_RecyclerView)

       // listLugares = createMockLugares()
        listLugares = loadMockLugaresFromJson()

        lugaresAdapter = LugaresAdapter(listLugares, onItemClicked = { onLugarClicked(it)} )

        // Desplazar el recycler view de forma vertical

        lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }

    }

    private fun onLugarClicked(lugar: LugarItem) {
        Log.d("alias", lugar.title)
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("lugar",lugar)
        startActivity(intent)
    }

    private fun loadMockLugaresFromJson(): ArrayList<LugarItem> {
        val lugarString: String = applicationContext.assets.open("lugares.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(lugarString, Lugar::class.java)
        return data
    }

}