package com.godbless.gymbro.user.exception

sealed class UserException(val error : String?) {
  data class NotFound(val msgError: String? = null): UserException(msgError ?: "Usuario no encontrado")
  data class NullException(val msgError: String? = null) : UserException(msgError ?: "El usuario es null")
}