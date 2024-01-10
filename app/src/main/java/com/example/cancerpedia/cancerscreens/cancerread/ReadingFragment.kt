package com.example.cancerpedia.cancerscreens.cancerread

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cancerpedia.R
import com.example.cancerpedia.cancerscreens.cancerpedia.CancerViewModel
import com.example.cancerpedia.databinding.FragmentReadingBinding


class ReadingFragment : Fragment() {
    private val args by navArgs<ReadingFragmentArgs>()
    private lateinit var cancerViewModel: CancerViewModel
    private var myRead: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentReadingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_reading,container, false)
        //Getting back the state of myRead
        if(savedInstanceState !=null){
            myRead = savedInstanceState.getString("myRead")
        }
        //Finding the actionbar of previous fragment
        val previousFragment = findNavController().previousBackStackEntry?.destination?.label
        // I don't fully understand how this works, but it does!
        previousFragment?.let {
            when(previousFragment){
                "Рак горла"  ->
                    (activity as AppCompatActivity).supportActionBar?.title = "Simon was here"
            }
        }
        //Here is where most of the work is done
       cancerViewModel = ViewModelProvider(this)[CancerViewModel::class.java]
        cancerViewModel.getAllCancer.observe(viewLifecycleOwner) { cancer ->
            for (cancers in cancer){
                //We get different results depending on the label and on the element pressed in CancerDescription
                if (cancers.name == (activity as AppCompatActivity).supportActionBar?.title){
                    when(args.currentReading.descrName){
                        "Определение" -> myRead = cancers.def
                        "Виды" -> myRead = cancers.types
                        "Симптомы" -> myRead = cancers.sympt
                        "Стадии" -> myRead = cancers.stage
                        "Причины" -> myRead = cancers.cause
                        "Диагностика" -> myRead = cancers.diagn
                        "Лечение" -> myRead = cancers.treat
                    }
                }
                binding.readingText.text = myRead
            }
            //Here we set the label on ReadingFragment back to the name of the element pressed
            (activity as AppCompatActivity).supportActionBar?.title = args.currentReading.descrName
        }
        return binding.root
    }
    //Savin the state of myRead
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("myRead",myRead)
    }
}