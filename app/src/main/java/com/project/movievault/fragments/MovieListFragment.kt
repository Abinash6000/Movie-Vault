package com.project.movievault.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.project.movievault.adapters.MyShowsItemClickListener
import com.project.movievault.adapters.ShowsAdapter
import com.project.movievault.databinding.FragmentMovieListBinding
import com.project.movievault.model.ShowDetails
import com.project.movievault.viewmodel.MovieViewModel

class MovieListFragment : Fragment(), MyShowsItemClickListener {

    private val viewModel: MovieViewModel by viewModels()
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.shows.observe(viewLifecycleOwner) { data ->
            Log.d("adfasl", "Data Changed $data")

            val showsAdp = ShowsAdapter(data, this)
            binding.showsRV.adapter = showsAdp
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onShowItemClicked(showDetails: ShowDetails) {
        val action = MovieListFragmentDirections.actionMovieListFragmentToDetailsFragment(showDetails)
        findNavController().navigate(action)
    }


}