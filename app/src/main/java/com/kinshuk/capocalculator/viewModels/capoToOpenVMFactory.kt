package com.kinshuk.capocalculator.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class capoToOpenVMFactory : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CapoToOpenViewModel::class.java)) {
            return CapoToOpenViewModel() as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}