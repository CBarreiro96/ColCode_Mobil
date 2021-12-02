package com.support.myapplicationmobil.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.support.myapplicationmobil.R
import com.support.myapplicationmobil.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)

        val titulo = intent.extras?.getString("titulo")
        detalleBinding.Titulo.text= titulo
    }
}