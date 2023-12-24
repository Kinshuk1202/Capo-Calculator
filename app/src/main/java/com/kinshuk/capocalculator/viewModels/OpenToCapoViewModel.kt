package com.kinshuk.capocalculator.viewModels

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kinshuk.capocalculator.dataClasses.CapoToOpen
import com.kinshuk.capocalculator.dataClasses.OpenToCapo

class OpenToCapoViewModel : ViewModel(), Observable {

    @Bindable
    var enteredChord = MutableLiveData<String>()
    @Bindable
    var selectedFret = MutableLiveData<String>()
    @Bindable
    var finalchord = MutableLiveData<String>()
    var openToCapoUtil:OpenToCapo

    init {
        selectedFret.value = "No Capo"
        enteredChord.value = ""
        finalchord.value = ""
        this.openToCapoUtil = OpenToCapo()
    }

    fun updateNewChord(currentChord:String,fretNo:Int)
    {
        if(currentChord.isEmpty()){
            finalchord.value = ""
            return
        }
        var temp:String = currentChord[0].uppercase()
        var remIdx = 1
        if(currentChord.length>1 && currentChord[1] == '#') {
            temp += currentChord[1]
            remIdx = 2
        }
        val remainingChord = currentChord.substring(remIdx)
        val curPositon = openToCapoUtil.getCurrentScaleIdx(temp)
        setFretValue(fretNo)
        if(curPositon == -1)
        {
            finalchord.value = "-"
            setFretValue(fretNo)
        }
        else
        {
            val newPostion = (curPositon?.plus(fretNo))?.rem(12)
            val newScale = openToCapoUtil.getNewScale(newPostion!!)
            finalchord.value = newScale +remainingChord
        }

    }

    private fun setFretValue(fretNo: Int) {
        when(fretNo)
        {
            0->{
                selectedFret.value = "No Capo"
            }
            1->{
                selectedFret.value = "Capo On: 1st fret"
            }
            2->{
                selectedFret.value = "Capo On: 2nd fret"
            }
            3->{
                selectedFret.value = "Capo On: 3th fret"
            }
            else->{
                selectedFret.value = "Capo On: ${fretNo}th fret"
            }
        }

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}