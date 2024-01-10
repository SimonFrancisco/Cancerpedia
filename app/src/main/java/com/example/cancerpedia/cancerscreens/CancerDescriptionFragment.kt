package com.example.cancerpedia.cancerscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cancerpedia.R
import com.example.cancerpedia.databinding.FragmentCancerDescriptionBinding
import com.example.cancerpedia.databinding.FragmentReadingBinding

class CancerDescriptionFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataDescr: ArrayList<CancerDescriptionData>
    private lateinit var imageList: Array<Int>
    private lateinit var nameList:Array<String>
    private lateinit var cancerViewModel: CancerViewModel
    private val args by navArgs<CancerDescriptionFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // get a reference to the binding object and inflate the fragments views
        val binding: FragmentCancerDescriptionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_cancer_description,container, false)
        //Creating Lists of names and images
        imageList = arrayOf(
            R.drawable.definition,
            R.drawable.types,
            R.drawable.symptoms,
            R.drawable.stage,
            R.drawable.cause,
            R.drawable.diagnosis,
            R.drawable.treatment
        )
        nameList = arrayOf(
            "Определение",
            "Виды",
            "Симптомы",
            "Стадии",
            "Причины",
            "Диагностика",
            "Лечение"
        )
        // Setting up Recycler View
        recyclerView = binding.cancerDescription
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)

        dataDescr = arrayListOf<CancerDescriptionData>()
        //Calling the function that adds elements to our lists
        getData()
        /*cancerViewModel = ViewModelProvider(this)[CancerViewModel::class.java]
        cancerViewModel.getAllCancer.observe(viewLifecycleOwner) { cancer ->
            CancerDescriptionAdapter(dataDescr).getId(cancer[args.currentDescription.id].id)
        }*/
        //CancerDescriptionAdapter(dataDescr).currentId = args.currentDescription.id
        /*CancerDescriptionAdapter(dataDescr).getId(args.currentDescription.id)
        var currentId = args.currentDescription.id*/
        (activity as AppCompatActivity).supportActionBar?.title = args.currentDescription.name

        val bundle = Bundle()
        binding.cancerDescription.setOnClickListener{
            bundle.putInt("position",args.currentDescription.id)
            findNavController().navigate(R.id.readingFragment, bundle)
        }
        return binding.root
    }
    private fun getData(){
        for(i in imageList.indices){
            val cancerDescriptionData = CancerDescriptionData(nameList[i],imageList[i])
            dataDescr.add(cancerDescriptionData)

        }
        recyclerView.adapter = CancerDescriptionAdapter(dataDescr)
       // CancerDescriptionAdapter(dataDescr).getId(args.currentDescription.id)
    }
}