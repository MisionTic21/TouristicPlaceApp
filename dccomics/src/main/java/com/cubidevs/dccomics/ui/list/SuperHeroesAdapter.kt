package com.cubidevs.dccomics.ui.list

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
import com.cubidevs.dccomics.model.TurismoItem
import com.squareup.picasso.Picasso

class SuperHeroesAdapter(
  //  private val superheroesList: ArrayList<SuperheroeItem>,
 //   private val onItemClicked: (SuperheroeItem) -> Unit
    private val superheroesList: ArrayList<TurismoItem>,
    private val onItemClicked: (TurismoItem) -> Unit


) : RecyclerView.Adapter<SuperHeroesAdapter.SuperheroeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_superheroe_item, parent, false)
        return SuperheroeViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroeViewHolder, position: Int) {
     //   val superheroe = superheroesList[position]
        val turismo = superheroesList[position]
        holder.itemView.setOnClickListener { onItemClicked(superheroesList[position]) }
      //  holder.bind(superheroe)
          holder.bind(turismo)
    }

    override fun getItemCount(): Int = superheroesList.size

   // fun appendItems(newItems: ArrayList<SuperheroeItem>) {

    fun appendItems(newItems: ArrayList<TurismoItem>) {
        superheroesList.clear()
        superheroesList.addAll(newItems)
        notifyDataSetChanged()
    }

    class SuperheroeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.nombre_textview)
        private var aliasTextView: TextView = itemView.findViewById(R.id.altura_textview)
        private var tiempoTextview: TextView = itemView.findViewById(R.id.time_textview)
        private var calificacionRatingBar: RatingBar = itemView.findViewById(R.id.calificacion_ratingBar )
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

      //  fun bind(superheroe: SuperheroeItem){
          fun bind(turismo: TurismoItem){
            Log.d("nombre",turismo.name)
            nameTextView.text = turismo.name
            aliasTextView.text = turismo.height
            tiempoTextview.text=turismo.time
            calificacionRatingBar.rating=turismo.score.toFloat()
            calificacionRatingBar.refreshDrawableState()

            Picasso.get().load(turismo.urlPicture).into(pictureImageView)
        }
    }
}