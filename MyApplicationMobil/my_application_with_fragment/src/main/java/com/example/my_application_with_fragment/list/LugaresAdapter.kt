package com.example.my_application_with_fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_application_with_fragment.R
import com.example.my_application_with_fragment.model.LugarItem
import com.squareup.picasso.Picasso



class LugaresAdapter(
    //Seleccionar el cardview
    private val lugaresList:ArrayList<LugarItem>,
    private val onItemClicked: (LugarItem) -> Unit

    ) : RecyclerView.Adapter<LugaresAdapter.lugarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): lugarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_lugar_item,parent,false)
        return lugarViewHolder(view)
    }

    override fun onBindViewHolder(holder: lugarViewHolder, position: Int) {
        val lugar = lugaresList[position]
        holder.itemView.setOnClickListener { onItemClicked(lugaresList[position]) }
        holder.bind(lugar)

    }

    override fun getItemCount(): Int = lugaresList.size


    class lugarViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        private var titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)
        //Detallara los parametros que estan en la clase lugar

        //Aqui relaciona la informacion con el cardview
        fun bind(lugar: LugarItem){
            titleTextView.text = lugar.title
            descriptionTextView.text = lugar.description
            Picasso.get().load(lugar.urlPicture).into(pictureImageView)
        }
    }
}