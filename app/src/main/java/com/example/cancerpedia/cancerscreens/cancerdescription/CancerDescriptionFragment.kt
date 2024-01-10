package com.example.cancerpedia.cancerscreens.cancerdescription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cancerpedia.R
import com.example.cancerpedia.cancerscreens.cancerpedia.CancerViewModel
import com.example.cancerpedia.databinding.FragmentCancerDescriptionBinding

class CancerDescriptionFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataDescr: ArrayList<CancerDescriptionData>
    private lateinit var imageList: Array<Int>
    private lateinit var nameList:Array<String>
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
        (activity as AppCompatActivity).supportActionBar?.title = args.currentDescription.name


        return binding.root
    }
    private fun getData(){
        for(i in imageList.indices){
            val cancerDescriptionData = CancerDescriptionData(nameList[i],imageList[i])
            dataDescr.add(cancerDescriptionData)

        }
        recyclerView.adapter = CancerDescriptionAdapter(dataDescr)
    }
}