package com.support.myapplicationmobil


import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListLugaresActivity : AppCompatActivity() {

    private lateinit var listLugares: ArrayList<Lugar>
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

    private fun loadMockLugaresFromJson(): ArrayList<Lugar> {
        var lugarString: String = applicationContext.assets.open("lugares.json").bufferedReader().use { it.readText() }
    }

    private fun createMockLugares() : ArrayList<Lugar>{
        // Lista en la que va esta en recycler view
        return arrayListOf(
            Lugar(
                title = "Lugar1",
                description = "8-10",
                urlPicture = "https://encolombia.com/wp-content/uploads/2012/12/Pereira-Ecoparque-La-Granja-de-Noe.jpg"
            ),
            Lugar(
                title = "Lugar2",
                description = "9-10",
                urlPicture = "https://blogapi.uber.com/wp-content/uploads/2018/05/X-planes-para-hacer-en-Pereira-en-el-fin-de-semana_Jardi%CC%81n-Bota%CC%81nico.png"

            ),
            Lugar(
                title = "lUGAR3",
                description = "8-10",
                urlPicture = "https://blogapi.uber.com/wp-content/uploads/2018/05/X-planes-para-hacer-en-Pereira-en-el-fin-de-semana_Jardi%CC%81n-Bota%CC%81nico.png"
            )
        )
    }
}