package com.dallmeier.domain.base

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type?)

    fun onError(throwable: Throwable)
}