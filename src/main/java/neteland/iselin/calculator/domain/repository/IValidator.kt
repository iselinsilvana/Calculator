package neteland.iselin.calculator.domain.repository

interface IValidator {

    fun validateExpression(expression:String): Boolean
}