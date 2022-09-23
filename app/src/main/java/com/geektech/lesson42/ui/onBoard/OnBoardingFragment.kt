package com.geektech.lesson42.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.geektech.lesson42.data.Preference
import com.geektech.lesson42.databinding.FragmentOnBoardingBinding
import com.geektech.lesson42.ui.onBoard.adapter.OnBoardAdapter

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardAdapter(){
            Preference(requireContext()).showBoarding(true)
            findNavController().navigateUp()
        }
        binding.onBoarding.adapter = adapter

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(binding.onBoarding)

        binding.indicator.attachToRecyclerView(binding.onBoarding, pagerSnapHelper)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

    }
}

