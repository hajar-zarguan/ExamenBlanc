package org.hajar.commun.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*


abstract class BaseCommandInfraction<T> (
        @TargetAggregateIdentifier
        open val id :T
        )
data class CreateInfractionCommand(
        override val id :String,
        var date :Date,
        var numradar :String,
        var montant :Double,
        var matricule :String,
        var vitessevehicule :Double,
        var vitessemax :Double
        ) : BaseCommandInfraction<String>(id);
data class UpdateInfractionCommand(
        override val id :String,
        var date :Date,
        var numradar :String,
        var montant :Double,
        var matricule :String,
        var vitessevehicule :Double,
        var vitessemax :Double
) : BaseCommandInfraction<String>(id);

data class DeleteInfractionCommand(
        override val id :String,
) : BaseCommandInfraction<String>(id);

