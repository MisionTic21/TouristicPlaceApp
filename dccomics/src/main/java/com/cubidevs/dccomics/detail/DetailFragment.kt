package com.cubidevs.dccomics.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cubidevs.dccomics.databinding.FragmentDetailBinding
import com.cubidevs.dccomics.main.MainActivity
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
        val superheroe = args.superheroe

        with(detailBinding){
            nameTextView.text = superheroe.name
            aliasTextView.text = superheroe.alias
            cityTextView.text = superheroe.city
            occupationTextView.text = superheroe.occupation
            heightTextView.text = superheroe.height.toString()
            facebookTextView.text = superheroe.facebook
            powersTextView.text = superheroe.powers
            Picasso.get().load(superheroe.urlPicture).into(pictureImageView)

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment())
            }
        }
    }
}