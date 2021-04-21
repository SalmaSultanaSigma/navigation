package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import com.example.navigation.databinding.FragmentMainBinding


class MainFragment : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        //setContentView(binding.root)
//
//    }

    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.secondFragmentbtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondFragment)
        }
        binding.thirdFragmentbtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_thirdFragment)
        }

    }

}