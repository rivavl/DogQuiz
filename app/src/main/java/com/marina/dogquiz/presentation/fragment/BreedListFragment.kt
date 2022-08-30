package com.marina.dogquiz.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.marina.dogquiz.R
import com.marina.dogquiz.data.repository.BreedGuideRepositoryImpl
import com.marina.dogquiz.databinding.FragmentBreedListBinding
import com.marina.dogquiz.domain.use_case.GetBreedsUseCase
import com.marina.dogquiz.presentation.adapter.BreedItemAdapter
import com.marina.dogquiz.presentation.view_model.BreedViewModel
import com.marina.dogquiz.presentation.view_model.BreedViewModelFactory

class BreedListFragment : Fragment(R.layout.fragment_breed_list) {

    private lateinit var viewModel: BreedViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var breedItemAdapter: BreedItemAdapter

    private var _binding: FragmentBreedListBinding? = null
    private val binding: FragmentBreedListBinding
        get() = _binding ?: throw RuntimeException("FragmentBreedListBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBreedListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repo = BreedGuideRepositoryImpl()
        val viewModelFactory = BreedViewModelFactory(GetBreedsUseCase(repo))
        viewModel = ViewModelProvider(this, viewModelFactory)[BreedViewModel::class.java]
        setupRecyclerView()
        observeViewModel()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        breedItemAdapter.onBreedClick = {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, BreedImagesFragment.getInstance(it.name))
                .commit()
        }
    }

    private fun setupRecyclerView() {
        recyclerView = binding.rvBreeds
        breedItemAdapter = BreedItemAdapter()
        recyclerView.apply {
            adapter = breedItemAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.breeds.observe(viewLifecycleOwner) {
            breedItemAdapter.submitList(it)
        }
    }
}