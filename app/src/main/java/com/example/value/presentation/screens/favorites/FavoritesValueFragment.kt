package com.example.value.presentation.screens.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.value.App
import com.example.value.R
import com.example.value.databinding.FragmentFavoritesValueBinding
import com.example.value.presentation.screens.value.ValueAdapter
import javax.inject.Inject

class FavoritesValueFragment : Fragment(R.layout.fragment_favorites_value) {

    @Inject
    lateinit var viewModel: FavoritesViewModel

    private val adapter = ValueAdapter(onFavoriteClick = { value->
        viewModel.changeFavorites(value)
    })
    private var _binding: FragmentFavoritesValueBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesValueBinding.inflate(inflater)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.rvValues.adapter = adapter
        viewModel.observe(this) { listValues ->
            adapter.updateAdapter(listValues)
        }
        viewModel.fetchValue()
    }
}