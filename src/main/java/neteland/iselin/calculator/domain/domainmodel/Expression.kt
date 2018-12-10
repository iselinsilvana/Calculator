package neteland.iselin.calculator.domain.domainmodel

class Expression private constructor(
    var result: String,
    val successful: Boolean) {

    companion object {
        fun createSuccessModel(result: String): Expression {
            return Expression(result,
                true)
        }

        fun createFailureModel(result: String): Expression {
            return Expression(result,
                false)
        }
    }
}