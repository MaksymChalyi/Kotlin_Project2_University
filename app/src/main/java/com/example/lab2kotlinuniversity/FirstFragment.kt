package com.example.lab2kotlinuniversity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2kotlinuniversity.databinding.FragmentFirstBinding
import com.example.myappforkotlin.Animal
import com.example.myappforkotlin.CustomAdapter

class FirstFragment : Fragment(), CustomAdapter.Listener {
    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var animals = ArrayList<Animal>()
    lateinit var adapter: CustomAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cat = Animal(getString(R.string.NameAnimal1), getString(R.string.kindAnimal1), getString(R.string.urlOfCat), getString(R.string.fullDescriptionOfCat))
        var dog = Animal(getString(R.string.NameAnimal2), getString(R.string.kindAnimal2), getString(R.string.urlOfDog),getString(R.string.fullDescriptionOfDog))
        var rabbit = Animal (getString(R.string.NameAnimal3), getString(R.string.kindAnimal3), getString(R.string.urlOfRabbit),getString(R.string.fullDescriptionOfRabbit))

        animals.add(cat)
        animals.add(dog)
        animals.add(rabbit)
        adapter = CustomAdapter(this ,animals, this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // method for work with button etc.
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(SecondFragment.numberInArray to itemView,
            SecondFragment.name to animals.get(itemView).name,
            SecondFragment.desc to animals.get(itemView).shortDesc,
            SecondFragment.url to animals.get(itemView).urlIcon,
            SecondFragment.fullDesc to animals.get(itemView).fullDesc)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)

    }
}