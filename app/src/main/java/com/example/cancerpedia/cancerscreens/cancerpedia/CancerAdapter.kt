package com.example.cancerpedia.cancerscreens.cancerpedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cancerpedia.R
import com.example.cancerpedia.database.Cancer

class CancerAdapter:RecyclerView.Adapter<CancerAdapter.MyViewHolder>() {

    private var cancerList = emptyList<Cancer>()

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val cancerImage:ImageView = itemView.findViewById(R.id.cancer_image)
        val cancerTitle:TextView = itemView.findViewById(R.id.cancer_string)
        val cancerLayout:RelativeLayout = itemView.findViewById(R.id.cancerLayout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_cancer_type,parent,false))
    }

    override fun getItemCount(): Int {
       return cancerList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCancer = cancerList[position]

        //Setting cancer names from data base
        holder.cancerTitle.text = currentCancer.name
        //Setting the pictures according the to the cancer type
        holder.cancerImage.setImageResource(when(currentCancer.id){
            0 -> R.drawable.throat_cancer
            1 -> R.drawable.breast_cancer
            2 -> R.drawable.oral_cancer
            3 -> R.drawable.stomach_cancer
            4 -> R.drawable.colon_cancer
            5 -> R.drawable.bone_cancer
            6 -> R.drawable.lung_cancer
            7 -> R.drawable.cervical_cancer
            8 -> R.drawable.brain_cancer
            9 -> R.drawable.prostate_cancer
            else->R.drawable.cancer
        })
        holder.cancerLayout.setOnClickListener{
            val action = CancerFragmentDirections.actionCancerFragmentToCancerDescriptionFragment(currentCancer)
            holder.itemView.findNavController().navigate(action)

        }

    }
    fun setData(cancer:List<Cancer>){
        this.cancerList = cancer
        notifyDataSetChanged()
    }
}