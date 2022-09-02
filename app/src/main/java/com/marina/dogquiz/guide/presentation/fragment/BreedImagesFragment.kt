package com.marina.dogquiz.guide.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marina.dogquiz.R
import com.marina.dogquiz.guide.data.repository.BreedGuideRepositoryImpl
import com.marina.dogquiz.databinding.FragmentBreedImagesBinding
import com.marina.dogquiz.guide.domain.use_case.GetImagesUseCase
import com.marina.dogquiz.guide.presentation.adapter.BreedImageAdapter
import com.marina.dogquiz.guide.presentation.view_model.ImageViewModelFactory
import com.marina.dogquiz.guide.presentation.view_model.ImagesViewModel

class BreedImagesFragment : Fragment() {

    private var currentBreed: String = ""

    private lateinit var viewModel: ImagesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: BreedImageAdapter

    private var _binding: FragmentBreedImagesBinding? = null
    private val binding: FragmentBreedImagesBinding
        get() = _binding ?: throw RuntimeException("FragmentBreedImagesBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBreedImagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parseParams()
        val repo = BreedGuideRepositoryImpl()
        val viewModelFactory = ImageViewModelFactory(GetImagesUseCase(repo))
        viewModel = ViewModelProvider(this, viewModelFactory)[ImagesViewModel::class.java]
        viewModel.getImagesList(currentBreed)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        recyclerView = binding.rvBreedImages
        imageAdapter = BreedImageAdapter()
        recyclerView.apply {
            adapter = imageAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun observeViewModel() {
        viewModel.images.observe(viewLifecycleOwner) {
            imageAdapter.submitList(it)
        }
    }

    private fun parseParams() {
        val args = requireArguments()
        if (!args.containsKey(BREED_NAME)) {
            throw RuntimeException("param is absent")
        }
        currentBreed = args.getString(BREED_NAME).toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val BREED_NAME = "breed_id"

        fun getInstance(name: String): BreedImagesFragment {
            return BreedImagesFragment().apply {
                arguments = Bundle().apply {
                    putString(BREED_NAME, name)
                }
            }
        }
    }
}