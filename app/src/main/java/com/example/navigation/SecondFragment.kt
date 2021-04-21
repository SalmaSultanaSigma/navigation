package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button4.setOnClickListener {
            val name:String= binding.editText.text.toString()
            val ballance: Int = binding.editText2.text.toString().toInt()

            val user=User(name,ballance)

            val action: NavDirections = SecondFragmentDirections.actionSecondFragmentToShowDetails(user)

            findNavController().navigate(action)

        }
        binding.button3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.secondFragment)
        }
    }
}