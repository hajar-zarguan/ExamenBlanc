package org.hajar.commun.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier


abstract class BaseCommandRadar<T> (
        @TargetAggregateIdentifier
        open val id :T
        )
data class CreateRadarCommand(
        override val id :String,
        var vitessemax :Double,
        var longtitude :String,
        var latitude :String
        ) : BaseCommandRadar<String>(id);
data class UpdateRadarCommand(
        override val id :String,
        var vitessemax :Double,
        var longtitude :String,
        var latitude :String
) : BaseCommandRadar<String>(id);

data class DeleteRadarCommand(
        override val id :String,
) : BaseCommandRadar<String>(id);

