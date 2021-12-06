package com.example.my_application_with_fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_application_with_fragment.databinding.FragmentListBinding
import com.example.my_application_with_fragment.model.Lugar
import com.example.my_application_with_fragment.model.LugarItem
import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listLugares: ArrayList<LugarItem>
    private lateinit var listBinding: FragmentListBinding
    private lateinit var lugaresAdapter: LugaresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listLugares = loadMockLugaresFromJson()
        lugaresAdapter = LugaresAdapter(listLugares, onItemClicked = { onLugarClicked(it)} )

        listBinding.LugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }

    private fun onLugarClicked(lugar: LugarItem) {
        //TODO programar detalles
    }

    private fun loadMockLugaresFromJson(): ArrayList<LugarItem> {
        val lugarString: String = context?.assets?.open("lugares.json")?.bufferedReader().use { it!!.readText() } //TODO reparar!!
        val gson = Gson()
        val data = gson.fromJson(lugarString, Lugar::class.java)
        return data
    }
}