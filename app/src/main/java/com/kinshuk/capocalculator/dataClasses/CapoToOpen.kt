package com.kinshuk.capocalculator.dataClasses

class CapoToOpen {
    private val circleOfSacles: ArrayList<String> = arrayListOf("C", "C#", "D", "D#", "E",
                                                                "F", "F#", "G", "G#", "A", "A#", "B")

    private  var  ScaleIdx: HashMap<String,Int> = hashMapOf()
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
    fun getNewScale(position: Int): String {
        return circleOfSacles[position]
    }
}