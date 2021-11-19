package com.cubidevs.holaandroid

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SuperHeroesAdapter(
    private val superheroesList: ArrayList<SuperheroeItem>
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

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var aliasTextView: TextView = itemView.findViewById(R.id.alias_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(superheroe: SuperheroeItem){
            Log.d("nombre",superheroe.name)
            nameTextView.text = superheroe.name
            aliasTextView.text = superheroe.alias
            Picasso.get().load(superheroe.urlPicture).into(pictureImageView)
        }
    }
}