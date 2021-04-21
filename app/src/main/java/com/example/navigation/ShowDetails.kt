package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.navigation.databinding.FragmentShowDetailsBinding


class ShowDetails : Fragment() {
    private val args:ShowDetailsArgs by navArgs<ShowDetailsArgs>()

    private lateinit var binding: FragmentShowDetailsBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentShowDetailsBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        binding.showName2.text= args.currentUser?.uName
        binding.showDetails2.text=args.currentUser?.uBallance.toString()
        binding.ok2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_showDetails_to_mainFragment2)
        }
    }


}