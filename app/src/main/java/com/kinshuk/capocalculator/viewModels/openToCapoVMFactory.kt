package com.kinshuk.capocalculator.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class openToCapoVMFactory : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(OpenToCapoViewModel::class.java)) {
            return OpenToCapoViewModel() as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}