package org.hajar.commun.dtos

import java.util.*


data class InfractionRequestDto(
        var date : Date,
        var numradar :String="",
        var montant :Double=0.0,
        var matricule :String="",
        var vitessevehicule :Double=0.0,
        var vitessemax :Double=0.0
)

data class InfractionUpdateRequestDto(
        var id:String="",
        var date : Date,
        var numradar :String="",
        var montant :Double=0.0,
        var matricule :String="",
        var vitessevehicule :Double=0.0,
        var vitessemax :Double=0.0
)
data class InfractionDeleteRequestDto(
        var id:String="",
)