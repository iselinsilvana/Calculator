package neteland.iselin.calculator.domain.usecase


import io.reactivex.Flowable
import neteland.iselin.calculator.domain.BaseUseCase
import neteland.iselin.calculator.domain.domainmodel.Expression
import neteland.iselin.calculator.domain.repository.ICalculator
import neteland.iselin.calculator.domain.repository.IValidator
import neteland.iselin.calculator.util.scheduler.BaseSchedulerProvider
import neteland.iselin.calculator.util.error.ValidationException

class EvaluateExpression (private val calculator: ICalculator,
                          private val validator: IValidator,
                          private val scheduler: BaseSchedulerProvider):
        BaseUseCase<Expression> {
    override fun execute(expression: String): Flowable<Expression> {

        if (validator.validateExpression(expression)) {
            return calculator.evaluateExpression(expression)

                .flatMap { result ->
                    Flowable.just(Expression.createSuccessModel(result.value))
                }
                .subscribeOn(scheduler.getComputationScheduler())
        }

        return Flowable.just(Expression.createFailureModel(ValidationException.message))

    }
}