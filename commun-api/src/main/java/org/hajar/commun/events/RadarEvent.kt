package org.hajar.commun.commands

abstract class BaseRadarEvent<T> (
        open val id :T
)
data class CreatedRadarEvent(
        override val id :String,
        var vitessemax :Double,
        var longtitude :String,
        var latitude :String
        ) : BaseRadarEvent<String>(id);

data class UpdatedRadarEvent(
        override val id :String,
        var vitessemax :Double,
        var longtitude :String,
        var latitude :String
) : BaseRadarEvent<String>(id);
data class DeletedRadarEvent(
        override val id :String,
) : BaseRadarEvent<String>(id);

