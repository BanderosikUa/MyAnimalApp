package com.example.myanimalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimalapp.adapter.AnimalAdapter
import com.example.myanimalapp.databinding.ActivityMainBinding
import com.example.myanimalapp.model.AnimalModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AnimalAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AnimalAdapter()

        val LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = LayoutManager
        binding.recyclerView.adapter = adapter
        adapter.setList(myAnimals())
    }

    private fun myAnimals(): ArrayList<AnimalModel>{
        var animalList = ArrayList<AnimalModel>()

        val animal1 = AnimalModel("Cat", "A cat is a furry animal that has a long tail and sharp claws. Cats are often kept as pets. Cats are lions, tigers, and other wild animals in the same family.", "cat")
        animalList.add(animal1)

        val animal2 = AnimalModel("Dog", "The dog is a pet animal. A dog has sharp teeth so that it can eat flesh very easily, it has four legs, two ears, two eyes, a tail, a mouth, and a nose. It is a very clever animal and is very useful in catching thieves. It runs very fast, barks loudly and attacks the strangers.", "dog")
        animalList.add(animal2)

        val animal3 = AnimalModel("Hamster", "Hamsters are small to large muroid rodents with compact bodies, small, furry ears, short legs, wide feet, and short stubby tails. Body lengths range from 50 mm to 340 mm, and tail lengths range from 7 to 106 mm. Females of some species are larger than males. Hamsters have long, thick fur.", "hamster")
        animalList.add(animal3)

        return animalList
    }

//        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
//            this, R.layout.activity_main)
//        binding.cat = Animal("Test", "User")
}