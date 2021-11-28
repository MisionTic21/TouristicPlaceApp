package com.cubidevs.holaandroid.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cubidevs.holaandroid.databinding.ActivityDetalleBinding
import com.cubidevs.holaandroid.model.SuperheroeItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val superheroe: SuperheroeItem = intent.extras?.getSerializable("superheroe") as SuperheroeItem

        with(detalleBinding){

            Picasso.get().load(superheroe.urlPicture).into(pictureImageView)
        }
    }
}