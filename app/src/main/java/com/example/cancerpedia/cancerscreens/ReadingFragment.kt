package com.example.cancerpedia.cancerscreens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.cancerpedia.R
import com.example.cancerpedia.databinding.FragmentCancerDescriptionBinding
import com.example.cancerpedia.databinding.FragmentReadingBinding


class ReadingFragment : Fragment() {
    private val args by navArgs<ReadingFragmentArgs>()
    private lateinit var cancerViewModel: CancerViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // get a reference to the binding object and inflate the fragments views
        val binding: FragmentReadingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_reading,container, false)
        //val position = arguments?.getInt("position")
        //changing the action bar according to type of cancer
        (activity as AppCompatActivity).supportActionBar?.title = args.currentReading.descrName

       /* cancerViewModel = ViewModelProvider(this)[CancerViewModel::class.java]
        cancerViewModel.getAllCancer.observe(viewLifecycleOwner) { cancer ->

            if (cancer[position!!].id==position){
                when (args.currentReading.descrName) {
                    "Определение" -> binding.readingText.text = cancer[position].def
                    "Виды" -> binding.readingText.text = cancer[position].types
                    "Симптомы" -> binding.readingText.text = cancer[position].sympt
                    "Стадии" -> binding.readingText.text = cancer[position].stage
                    "Причины" -> binding.readingText.text = cancer[position].cause
                    "Диагностика" -> binding.readingText.text = cancer[position].diagn
                    "Лечение" -> binding.readingText.text = cancer[position].treat
                }
            }
                *//*when (args.currentReading.descrName) {
                    "Определение" -> binding.readingText.text =
                    "Виды" -> binding.readingText.text = cancer[cancers].types
                    "Симптомы" -> binding.readingText.text = cancer[cancers].sympt
                    "Стадии" -> binding.readingText.text = cancer[cancers].stage
                    "Причины" -> binding.readingText.text = cancer[cancers].cause
                    "Диагностика" -> binding.readingText.text = cancer[cancers].diagn
                    "Лечение" -> binding.readingText.text = cancer[cancers].treat
                }*//*

        }*/
        /*val arguments = CancerDescriptionFragmentArgs.fromBundle(requireArguments())

        when(args.currentReading.descrName){
            "Определение" -> binding.readingText.text = arguments.currentDescription.name
            "Виды"-> binding.readingText.text = arguments.currentDescription.types
            "Симптомы" -> binding.readingText.text = arguments.currentDescription.sympt
            "Стадии" -> binding.readingText.text = arguments.currentDescription.stage
            "Причины" -> binding.readingText.text = arguments.currentDescription.cause
            "Диагностика" -> binding.readingText.text = arguments.currentDescription.diagn
            "Лечение" -> binding.readingText.text = arguments.currentDescription.treat
        }*/



        return binding.root
    }
}