package neteland.iselin.calculator.util.error

class ValidationException: Exception() {
    companion object {
        const val message = "Invalid expression"
    }
}