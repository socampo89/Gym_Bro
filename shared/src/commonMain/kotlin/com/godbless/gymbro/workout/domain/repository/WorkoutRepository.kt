package com.godbless.gymbro.workout.domain.repository

import com.godbless.gymbro.helpers.Either
import com.godbless.gymbro.workout.domain.entity.Workout
import com.godbless.gymbro.workout.exception.WorkoutException

interface WorkoutRepository {
    suspend fun getWorkouts(idUser : String) : Either<WorkoutException,List<Workout>>
}