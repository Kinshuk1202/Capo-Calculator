package com.kinshuk.capocalculator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.kinshuk.capocalculator.R
import com.kinshuk.capocalculator.databinding.FragmentHomeBinding
import com.kinshuk.capocalculator.databinding.FragmentOpenToCapoBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.capoTOopen.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_capoToOpenFragment)
        }
        binding.OpenTocapo.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_openToCapoFragment)
        }
    }


}