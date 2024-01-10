package com.example.cancerpedia.cancerscreens.cancerdescription

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cancerpedia.R
class CancerDescriptionAdapter(private var cancerDescr: ArrayList<CancerDescriptionData>):RecyclerView.Adapter<CancerDescriptionAdapter.ViewHolderClass>() {

    class ViewHolderClass(itemView: View):RecyclerView.ViewHolder(itemView) {
        val descrImage:ImageView = itemView.findViewById(R.id.description_image)
        val descrText:TextView = itemView.findViewById(R.id.description_text)
        val descrLayout:ConstraintLayout = itemView.findViewById(R.id.cancerDescriptionLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.description_layout,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return cancerDescr.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = cancerDescr[position]
        holder.descrImage.setImageResource(currentItem.descrImage)
        holder.descrText.text = currentItem.descrName

        holder.descrLayout.setOnClickListener{
            val readAction =
                CancerDescriptionFragmentDirections.actionCancerDescriptionFragmentToReadingFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(readAction)
        }

    }

}