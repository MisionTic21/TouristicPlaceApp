package com.cubidevs.holaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tituloTextView : TextView = findViewById(R.id.titulo_text_view)

        val nombre = intent.extras?.getString("nombre")
        tituloTextView.text = nombre

        nombre?.let { Log.d("nombre", it) }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
//Creación de la rama de develop