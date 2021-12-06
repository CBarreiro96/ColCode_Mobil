package com.example.my_application_with_fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.my_application_with_fragment.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding:FragmentDetailBinding
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lugar = args.lugar

        with(detailBinding){
            Titulo.text = lugar.title
            contentAbout.text = lugar.description
            contentUbication.text = lugar.lugar
            contentTemperature.text = lugar.temperatura
            Horario.text = lugar.horarios
            com.squareup.picasso.Picasso.get().load(lugar.urlPicture).into(imageView)
        }
    }
}