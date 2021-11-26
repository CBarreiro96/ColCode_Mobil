package com.support.myapplicationmobil


import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

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

        lugaresAdapter = LugaresAdapter(listLugares)

        // Desplazar el recycler view de forma vertical

        lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }

    }

    private fun loadMockLugaresFromJson(): ArrayList<LugarItem> {
        val lugarString: String = applicationContext.assets.open("lugares.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(lugarString,Lugar::class.java)
        return data
    }

}