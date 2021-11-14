package com.spg.wnc.domain.common

import java.lang.RuntimeException

class SpgException(
    val errorCode: ErrorCode,
    cause: Exception? = null
) : RuntimeException(cause)