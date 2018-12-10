package neteland.iselin.calculator.domain

import io.reactivex.Flowable

interface BaseUseCase<T> {
    fun execute(expression: String): Flowable<T>
}
