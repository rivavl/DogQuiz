package com.marina.dogquiz.guess_breed.presentation.fragment

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.marina.dogquiz.databinding.FragmentGuessBreedGameBinding
import com.marina.dogquiz.guess_breed.data.repository.GuessBreedRepositoryImpl
import com.marina.dogquiz.guess_breed.domain.entity.GameResult
import com.marina.dogquiz.guess_breed.domain.use_case.GetGameSettingsUseCase
import com.marina.dogquiz.guess_breed.domain.use_case.GetGuessBreedQuestionUseCase
import com.marina.dogquiz.guess_breed.presentation.view_model.GuessBreedGameViewModel
import com.marina.dogquiz.guess_breed.presentation.view_model.GuessBreedGameViewModelFactory

class GuessBreedGameFragment : Fragment() {

    private val args by navArgs<GuessBreedGameFragmentArgs>()

    private val viewModelFactory by lazy {
        val repo = GuessBreedRepositoryImpl()
        val getGameSettingsUseCase = GetGameSettingsUseCase(repo)
        val getGuessBreedQuestionUseCase = GetGuessBreedQuestionUseCase(repo)
        GuessBreedGameViewModelFactory(
            getGameSettingsUseCase,
            getGuessBreedQuestionUseCase,
            args.level,
            requireActivity().application
        )
    }

    private val viewModel: GuessBreedGameViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[GuessBreedGameViewModel::class.java]
    }

    private var _binding: FragmentGuessBreedGameBinding? = null
    private val binding: FragmentGuessBreedGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGuessBreedGameBinding == null")

    private val tvOptions by lazy {
        mutableListOf<TextView>().apply {
            add(binding.tvOption1)
            add(binding.tvOption2)
            add(binding.tvOption3)
            add(binding.tvOption4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuessBreedGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        setClickListenersToOptions()
    }

    private fun setClickListenersToOptions() {
        for (tvOption in tvOptions) {
            tvOption.setOnClickListener {
                viewModel.chooseAnswer(tvOption.text.toString())
            }
        }
    }

    private fun observeViewModel() {
        viewModel.question.observe(viewLifecycleOwner) {
            loadImage(it.imageUrl, binding.ivDog, requireContext())
            for (i in 0 until tvOptions.size) {
                tvOptions[i].text = it.answers[i].breed
            }
        }
        viewModel.percentOfRightAnswers.observe(viewLifecycleOwner) {
            binding.progressBar.setProgress(it, true)
        }
        viewModel.enoughCount.observe(viewLifecycleOwner) {
            binding.tvAnswersProgress.setTextColor(getColorByState(it))
        }
        viewModel.enoughPercent.observe(viewLifecycleOwner) {
            val color = getColorByState(it)
            binding.progressBar.progressTintList = ColorStateList.valueOf(color)
        }
        viewModel.formattedTime.observe(viewLifecycleOwner) {
            binding.tvTimer.text = it
        }
        viewModel.minPercent.observe(viewLifecycleOwner) {
            binding.progressBar.secondaryProgress = it
        }
        viewModel.gameResult.observe(viewLifecycleOwner) {
            launchGameFinishedFragment(it)
        }
        viewModel.progressAnswers.observe(viewLifecycleOwner) {
            binding.tvAnswersProgress.text = it
        }
    }

    private fun loadImage(url: String, imageView: ImageView, context: Context) {
        Glide.with(context)
            .load(url)
            .into(imageView)
    }

    private fun getColorByState(goodState: Boolean): Int {
        val colorResId = if (goodState) {
            android.R.color.holo_green_light
        } else {
            android.R.color.holo_red_light
        }
        return ContextCompat.getColor(requireContext(), colorResId)
    }


    private fun launchGameFinishedFragment(gameResult: GameResult) {
        findNavController().navigate(
            GuessBreedGameFragmentDirections.actionGuessBreedGameFragmentToGameFinishedFragment(
                gameResult
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}











