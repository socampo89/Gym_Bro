package com.godbless.gymbro.workout.domain.entity

import database.WorkoutEntity

fun WorkoutEntity.toWorkout() : Workout {
    return Workout(
        id = id,
        name = name
    )
}