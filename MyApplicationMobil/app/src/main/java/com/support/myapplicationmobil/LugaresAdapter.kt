package com.support.myapplicationmobil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class LugaresAdapter(
    private val lugaresList:ArrayList<Lugar>
    ) : RecyclerView.Adapter<LugaresAdapter.lugarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): lugarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_lugar_item,parent,false)
        return lugarViewHolder(view)
    }

    override fun onBindViewHolder(holder: lugarViewHolder, position: Int) {
        val lugar = lugaresList[position]
        holder.bind(lugar)

    }

    override fun getItemCount(): Int = lugaresList.size


    class lugarViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        private var titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)
        //Detallara los parametros que estan en la clase lugar

        fun bind(lugar: Lugar){
            titleTextView.text = lugar.title
            descriptionTextView.text = lugar.description
            Picasso.get().load(lugar.urlPicture).into(pictureImageView);
        }
    }
}