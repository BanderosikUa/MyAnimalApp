package com.example.myanimalapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myanimalapp.R
import com.example.myanimalapp.adapter.AnimalAdapter
import com.example.myanimalapp.databinding.FragmentFirstBinding
import com.example.myanimalapp.adapter.model.AnimalModel

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var adapter: AnimalAdapter
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        adapter = AnimalAdapter()

        binding.recyclerView.adapter = adapter
        adapter.setList(myAnimals())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        adapter.navController = navController

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun myAnimals(): ArrayList<AnimalModel>{
        var animalList = ArrayList<AnimalModel>()

        val animal1 = AnimalModel("Cat",
            "A cat is a furry animal that has a long tail and sharp claws. Cats are often kept as pets. Cats are lions, tigers, and other wild animals in the same family.",
            "https://e7.pngegg.com/pngimages/406/987/png-clipart-cute-cat-cartoon-cat-pet-cat.png")
        animalList.add(animal1)

        val animal2 = AnimalModel("Dog",
            "The dog is a pet animal. A dog has sharp teeth so that it can eat flesh very easily, it has four legs, two ears, two eyes, a tail, a mouth, and a nose. It is a very clever animal and is very useful in catching thieves. It runs very fast, barks loudly and attacks the strangers.",
            "https://banner2.cleanpng.com/20180820/lvw/kisspng-dog-clip-art-human-behavior-finger-headgear-doggy-dab-sticker-by-ftjunior-5b7b5d1be8d387.8243251715348114199537.jpg")
        animalList.add(animal2)

        val animal3 = AnimalModel("Hamster",
            "Hamsters are small to large muroid rodents with compact bodies, small, furry ears, short legs, wide feet, and short stubby tails. Body lengths range from 50 mm to 340 mm, and tail lengths range from 7 to 106 mm. Females of some species are larger than males. Hamsters have long, thick fur.",
            "https://cdn.shopify.com/s/files/1/0037/0268/5745/articles/home-yourpets-hamster_400x.jpg?v=1564696396")
        animalList.add(animal3)
        val bird = AnimalModel(
            "Bird",
            "Birds are vertebrate animals adapted for flight. Many can also run, jump, swim, and dive. Some, like penguins, have lost the ability to fly but retained their wings. Birds are found worldwide and in all habitats.",
            "https://easydrawingguides.com/wp-content/uploads/2020/11/Cartoon-Bird-Step-10.png"
        )
        animalList.add(bird)
        val monkey = AnimalModel(
            "Monkey",
            "Most species are arboreal, using all four limbs to leap from tree to tree. They can sit upright and stand erect. Most species run along branches rather than swinging arm over arm like the apes. Monkeys are highly social omnivores, organized in clans as large as several hundred individuals headed by an old male.",
            "https://img.freepik.com/premium-vector/cute-baby-monkey-cartoon-dabbing_188253-1659.jpg"
        )
        animalList.add(monkey)

        return animalList
    }
}