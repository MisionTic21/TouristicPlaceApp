package com.cubidevs.dccomics.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cubidevs.dccomics.databinding.FragmentDetailBinding
import com.cubidevs.dccomics.ui.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val superheroe = args.superheroe
        val turismo = args.turismo

        with(detailBinding){
            nombreTextview.text = turismo.name
            descripcionTextview.text = turismo.description
            alturaTextview.text = turismo.height.toString()
            timeTextview.text = turismo.time
//            heightTextView.text = turismo.height.toString()

            calificacionRatingBar.rating=turismo.score.toFloat()
            calificacionRatingBar.refreshDrawableState()

            Picasso.get().load(turismo.urlPicture).into(pictureImageView)

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment())
            }
        }
    }
}