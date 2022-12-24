package org.hajar.commun.commands

import java.util.*

abstract class BaseInfractionEvent<T> (
        open val id :T
)
data class CreatedInfractionEvent(
        override val id :String,
        var date :Date,
        var numradar :String,
        var montant :Double,
        var matricule :String,
        var vitessevehicule :Double,
        var vitessemax :Double
        ) : BaseInfractionEvent<String>(id);

data class UpdatedInfractionEvent(
        override val id :String,
        var date :Date,
        var numradar :String,
        var montant :Double,
        var matricule :String,
        var vitessevehicule :Double,
        var vitessemax :Double
) : BaseInfractionEvent<String>(id);
data class DeletedInfractionEvent(
        override val id :String,
) : BaseInfractionEvent<String>(id);

