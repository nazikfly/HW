package com.geektech.lesson42.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.geektech.lesson42.R
import com.geektech.lesson42.data.Preference
import com.geektech.lesson42.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var preference:Preference


    var mGetContent:ActivityResultLauncher<String> = registerForActivityResult(
            ActivityResultContracts.GetContent()
    )
    {   url->
        preference.setProfileImage(url.toString())
        Glide.with(requireContext()).load(url.toString()).into(binding.profileImage)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container:ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preference= Preference((requireContext()))
        Glide.with(requireContext()).load(preference.getProfileImage()).into(binding.profileImage)
        binding.profileImage.setOnClickListener{
            mGetContent.launch(("image/*"))
        }
    }
}