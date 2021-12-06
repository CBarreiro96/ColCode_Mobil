package com.support.myapplicationmobil.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.support.myapplicationmobil.model.LugarItem
import com.support.myapplicationmobil.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val lugar : LugarItem = intent.extras?.getSerializable("lugar") as LugarItem
        detalleBinding.Titulo.text= lugar.title

        with(detalleBinding){
            Titulo.text = lugar.title
            contentAbout.text = lugar.description
            contentUbication.text = lugar.lugar
            contentTemperature.text = lugar.temperatura
            Horario.text = lugar.horarios
            Picasso.get().load(lugar.urlPicture).into(imageView)

        }
    }
}