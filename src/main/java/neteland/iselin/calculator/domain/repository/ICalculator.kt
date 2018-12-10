package neteland.iselin.calculator.domain.repository

import io.reactivex.Flowable
import neteland.iselin.calculator.data.datamodel.ExpressionDataModel

interface ICalculator {

    fun evaluateExpression(expression:String): Flowable<ExpressionDataModel>
}