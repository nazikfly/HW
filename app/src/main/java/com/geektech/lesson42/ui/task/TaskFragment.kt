package com.geektech.lesson42.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.geektech.lesson42.databinding.FragmentTaskBinding
import com.geektech.lesson42.ui.Task

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            setFragmentResult(
                "tf_result",
                bundleOf(
                    "task" to Task(
                        binding.etTitle.text.toString(),
                        binding.etDescription.text.toString()
                    )
                )
            )
        }
        findNavController().navigateUp()
    }

    companion object {
        const val FRAGMENT_RESULT = "tf_result"
        const val TASK_KEY = "task.key"

    }
}



