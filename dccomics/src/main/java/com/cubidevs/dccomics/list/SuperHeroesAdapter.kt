package com.cubidevs.dccomics.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.dccomics.R
import com.cubidevs.dccomics.model.SuperheroeItem
import com.squareup.picasso.Picasso

class SuperHeroesAdapter(
    private val superheroesList: ArrayList<SuperheroeItem>,
    private val onItemClicked: (SuperheroeItem) -> Unit
) : RecyclerView.Adapter<SuperHeroesAdapter.SuperheroeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_superheroe_item, parent, false)
        return SuperheroeViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroeViewHolder, position: Int) {
        val superheroe = superheroesList[position]

        holder.itemView.setOnClickListener { onItemClicked(superheroesList[position]) }
        holder.bind(superheroe)
    }

    override fun getItemCount():Int{
        Log.d("size item",superheroesList.size.toString())
        return superheroesList.size
    }



    class SuperheroeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){



        private var nameTextView: TextView = itemView.findViewById(R.id.titulo_text_view)
        private var aliasTextView: TextView = itemView.findViewById(R.id.nombre_textview)
        private var calificacion_ratingBar: RatingBar = itemView.findViewById(R.id.calificacion_ratingBar)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(superheroe: SuperheroeItem){
            Log.d("nombre",superheroe.name)
            nameTextView.text = superheroe.name
            aliasTextView.text = superheroe.city
            calificacion_ratingBar.rating = superheroe.score.toFloat()
            calificacion_ratingBar.refreshDrawableState()
            Picasso.get().load(superheroe.urlPicture).into(pictureImageView)
        }
    }
}