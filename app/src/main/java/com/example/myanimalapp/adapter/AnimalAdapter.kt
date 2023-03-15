package com.example.myanimalapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimalapp.R
import com.example.myanimalapp.SecondActivity
import com.example.myanimalapp.databinding.ItemAnimalLayoutBinding
import com.example.myanimalapp.model.AnimalModel

class AnimalAdapter:RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private var animalList = emptyList<AnimalModel>()

    class AnimalViewHolder(var binding: ItemAnimalLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimalLayoutBinding.inflate(inflater, parent, false)

        return AnimalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animalList[position]
        val context = holder.itemView.context
        with(holder.binding){
            tvName.text = animal.name
            tvDescription.text = animal.description
            val photoId = context.resources.getIdentifier("${animal.photo}", "drawable", context.packageName)
            photo.setImageResource(photoId)
            button.setOnClickListener{
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("name", animal.name)
                intent.putExtra("description", animal.description)
                intent.putExtra("photoId", photoId)
                context.startActivity(intent)
            }
        }
    }

    fun setList(List: List<AnimalModel>){
        animalList = List
    }
}