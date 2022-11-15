package com.godbless.gymbro.workout.domain.usecases

import com.godbless.gymbro.base.BaseUseCase
import com.godbless.gymbro.helpers.Either
import com.godbless.gymbro.workout.domain.entity.Workout
import com.godbless.gymbro.workout.domain.repository.WorkoutRepository
import com.godbless.gymbro.workout.exception.WorkoutException

class GetWorkoutsUseCase(private val repository: WorkoutRepository) : BaseUseCase<WorkoutException, List<Workout>, String>() {
    override suspend fun invoke(params: String?): Either<WorkoutException, List<Workout>> {
        return params?.let {
            repository.getWorkouts(params)
        }?:run{
            Either.Left(WorkoutException.NullException())
        }
    }
}