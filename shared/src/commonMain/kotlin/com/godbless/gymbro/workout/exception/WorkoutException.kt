package com.godbless.gymbro.workout.exception


sealed class WorkoutException(val error : String?) {
  data class NotFound(val msgError: String? = null): WorkoutException(msgError ?: "No encontrado")
  data class NullException(val msgError: String? = null) : WorkoutException(msgError ?: "Parameter is null")
}