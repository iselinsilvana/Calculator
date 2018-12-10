package neteland.iselin.calculator.View

import io.reactivex.Flowable

interface IViewContract{

    interface View {
        fun getCurrentExpression(): String
        fun setDisplay(value:String)
        fun showError(value: String)
        fun restartFeature()
    }

    interface ViewModel {
        fun setDisplayState(result: String)
        fun getDisplayStatePublisher(): Flowable<String>
        fun getDisplayState(): String
    }

    interface Presenter {
        fun onEvaluateClick(expression: String)
        fun onInputButtonClick(value: String)
        fun onBackspaceClick()
        fun onDeleteClick ()
        fun bind()
        fun clear()
    }
}