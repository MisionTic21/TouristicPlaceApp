package com.cubidevs.dccomics.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cubidevs.dccomics.R
import com.cubidevs.dccomics.databinding.FragmentDetailBinding
import com.cubidevs.dccomics.ui.main.MainActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
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
//           heightTextView.text = turismo.height.toString()

            calificacionRatingBar.rating=turismo.score.toFloat()
            calificacionRatingBar.refreshDrawableState()
            Picasso.get().load(turismo.urlPicture).into(pictureImageView)
            val mapFragment = childFragmentManager.findFragmentById(R.id.map2) as SupportMapFragment?
            mapFragment?.getMapAsync(callback)


            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment(turismo))
            }
        }
    }

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        val turismo = args.turismo


        val lugar = LatLng(turismo.latitud,turismo.longitud)//(6.2428525, -75.5835155)
        googleMap.addMarker(
            MarkerOptions()
                .position(lugar)
                .title(turismo.name)
                .snippet(turismo.height)
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar,10F))


    }
}