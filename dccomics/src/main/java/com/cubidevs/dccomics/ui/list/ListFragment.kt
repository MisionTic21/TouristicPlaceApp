package com.cubidevs.dccomics.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubidevs.dccomics.databinding.FragmentListBinding
import com.cubidevs.dccomics.ui.main.MainActivity
import com.cubidevs.dccomics.model.SuperheroeItem
import com.cubidevs.dccomics.model.TurismoItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var superHeroesAdapter: SuperHeroesAdapter
   // private var listSuperheroes: ArrayList<SuperheroeItem> = arrayListOf()
    private var listSuperheroes: ArrayList<TurismoItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        //     listViewModel.loadMockSuperHeroesFromJson(context?.assets?.open("superheroes.json"))

        listViewModel.getSuperheroesFromServer()

        listViewModel.onSuperheroesLoaded.observe(viewLifecycleOwner, { result ->
            onSuperheroesLoadedSubscribe(result)
        })

        superHeroesAdapter = SuperHeroesAdapter(listSuperheroes, onItemClicked = { onSuperheroeClicked(it) } )

        listBinding.superheroesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = superHeroesAdapter
            setHasFixedSize(false)
        }
    }

    //private fun onSuperheroesLoadedSubscribe(result: ArrayList<SuperheroeItem>?) {
    private fun onSuperheroesLoadedSubscribe(result: ArrayList<TurismoItem>?) {
        result?.let { listSuperheroes ->
            superHeroesAdapter.appendItems(listSuperheroes)
            /*
            // TODO: revisar feedback
            this.listSuperheroes = listSuperheroes
            superHeroesAdapter.notifyDataSetChanged()
            */
        }
    }

    //private fun onSuperheroeClicked(superheroe: SuperheroeItem) {
    private fun onSuperheroeClicked(turismo: TurismoItem) {
       //findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(superheroe = superheroe))
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(turismo = turismo))
    }
}