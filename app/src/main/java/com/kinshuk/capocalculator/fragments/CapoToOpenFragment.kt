package com.kinshuk.capocalculator.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.kinshuk.capocalculator.R
import com.kinshuk.capocalculator.databinding.ActivityMainBinding
import com.kinshuk.capocalculator.databinding.FragmentCapoToOpenBinding
import com.kinshuk.capocalculator.viewModels.CapoToOpenViewModel
import com.kinshuk.capocalculator.viewModels.capoToOpenVMFactory
import java.text.FieldPosition


class CapoToOpenFragment : Fragment() {

    private lateinit var binding: FragmentCapoToOpenBinding
    private lateinit var viewModel:CapoToOpenViewModel
    private  var fretPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCapoToOpenBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this,capoToOpenVMFactory()).get(CapoToOpenViewModel::class.java)
        binding.myviewModel = viewModel
        binding.lifecycleOwner = this


        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.FretOption,
            R.layout.spinner_list
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.fretMenu.adapter = it
        }
        binding.fretMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                fretPosition = position
                viewModel.updateNewChord(binding.etChord.text.toString(), position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.etChord.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    var chord = p0.toString()
                    viewModel.updateNewChord(chord,fretPosition)
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        return binding.root
    }


}