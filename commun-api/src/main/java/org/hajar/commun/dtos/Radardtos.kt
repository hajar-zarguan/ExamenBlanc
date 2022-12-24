package org.hajar.commun.dtos


data class RadarRequestDto(
        var vitessemax :Double=0.0,
        var longtitude :String="",
        var latitude :String=""
)

data class RadarUpdateRequestDto(
        var id:String="",
        var vitessemax :Double=0.0,
        var longtitude :String="",
        var latitude :String=""
)
data class RadarDeleteRequestDto(
        var id:String="",
)