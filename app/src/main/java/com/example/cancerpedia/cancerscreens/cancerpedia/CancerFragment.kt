package com.example.cancerpedia.cancerscreens.cancerpedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cancerpedia.R
import com.example.cancerpedia.databinding.FragmentCancerBinding


class CancerFragment : Fragment() {
    private lateinit var cancerViewModel: CancerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // get a reference to the binding object and inflate the fragments views
        val binding: FragmentCancerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_cancer,container, false)

        cancerViewModel = ViewModelProvider(this)[CancerViewModel::class.java]
        //Recycler view
        val adapter = CancerAdapter()
        val recyclerView = binding.cancerList
        recyclerView.adapter = adapter
        val manager = GridLayoutManager(activity,2,LinearLayoutManager.VERTICAL,false)
        binding.cancerList.layoutManager = manager
        // Observing data in viewModel
        cancerViewModel.getAllCancer.observe(viewLifecycleOwner) { cancer ->
            adapter.setData(cancer)
        }
        //(activity as AppCompatActivity).supportActionBar?.title = "tttt"

        return binding.root
    }

}