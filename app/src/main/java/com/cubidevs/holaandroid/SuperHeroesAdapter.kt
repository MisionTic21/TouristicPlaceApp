package com.cubidevs.holaandroid

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SuperHeroesAdapter(
    private val superheroesList: ArrayList<TurismoItem>
) : RecyclerView.Adapter<SuperHeroesAdapter.SuperheroeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_superheroe_item, parent, false)
        return SuperheroeViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroeViewHolder, position: Int) {
        val superheroe = superheroesList[position]
        holder.bind(superheroe)
    }

    override fun getItemCount(): Int = superheroesList.size

    class SuperheroeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var ubicacionTextView: TextView = itemView.findViewById(R.id.ubicacion_text_view)
        private var temperaturaTextView: TextView = itemView.findViewById(R.id.temperatura_text_view)
        private var recomendadosTextView: TextView = itemView.findViewById(R.id.recomendados_text_view)
        private var scoreRating: RatingBar = itemView.findViewById(R.id.calificacion_ratingBar)
        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(superheroe: TurismoItem){
            Log.d("nombre",superheroe.name)
            nameTextView.text = superheroe.name
            ubicacionTextView.text = superheroe.description
            temperaturaTextView.text=superheroe.time
            recomendadosTextView.text=superheroe.description
            scoreRating.rating=superheroe.score.toFloat()
            scoreRating.refreshDrawableState()

            Picasso.get().load(superheroe.urlPicture).into(pictureImageView)
        }
    }
}