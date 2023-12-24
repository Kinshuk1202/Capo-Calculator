package com.kinshuk.capocalculator.dataClasses

class OpenToCapo {
    private val circleOfSacles: ArrayList<String> = arrayListOf("B","A#","A","G#","G","F#","F","E","D#","D","C#","C")

    private var  ScaleIdx: HashMap<String,Int> = hashMapOf()
    init {
        var index = 0;
        for(it in circleOfSacles)
            ScaleIdx[it] = index++
    }
    fun getCurrentScaleIdx(scale:String): Int? {
        if(ScaleIdx.containsKey(scale))
            return ScaleIdx[scale]
        else
            return -1
    }
    fun getNewScale(position: Int):String?{
        return circleOfSacles[position]
    }
}