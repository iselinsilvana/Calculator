package neteland.iselin.calculator.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.DisposableSubscriber
import neteland.iselin.calculator.View.IViewContract
import neteland.iselin.calculator.domain.domainmodel.Expression
import neteland.iselin.calculator.domain.usecase.EvaluateExpression
import neteland.iselin.calculator.util.scheduler.BaseSchedulerProvider

class CalculatorPresenter(private var view: IViewContract.View,
                          private var viewModel: IViewContract.ViewModel,
                          private val scheduler: BaseSchedulerProvider,
                          private val eval: EvaluateExpression
) : IViewContract.Presenter {

    private val eventStream = CompositeDisposable()

    private val EMPTY = ""

    //Update the state, then the view.
    override fun onDeleteClick() {
        viewModel.setDisplayState(EMPTY)
    }

    override fun onInputButtonClick(value: String) {
        viewModel.setDisplayState(
            viewModel.getDisplayState() + value
        )
    }

    override fun onBackspaceClick() {
        viewModel.setDisplayState(
            viewModel.getDisplayState().dropLast(1)
        )
    }

    override fun onEvaluateClick(expression: String) {
        //Presenter is the Observer
        eventStream.add(
            eval.execute(expression)
                .observeOn(scheduler.getUIScheduler())
                .subscribeWith(object : DisposableSubscriber<Expression>() {
                    override fun onNext(data: Expression?) {
                        if (data!!.successful) {
                            viewModel.setDisplayState(data.result)
                        } else {
                            view.showError(data.result)
                        }
                    }

                    //Reserved for fatal errors
                    override fun onError(t: Throwable?) {
                        restartFeature()
                    }

                    override fun onComplete() {
                    }
                })
        )
    }

    private fun restartFeature() {
        eventStream.clear()
        view.restartFeature()
    }

    override fun bind() {
        eventStream.add(

            viewModel.getDisplayStatePublisher()
                .subscribeWith(
                    object : DisposableSubscriber<String>() {
                        override fun onNext(displayState: String) {
                            view.setDisplay(displayState)
                        }

                        override fun onError(t: Throwable?) {
                            restartFeature()
                        }

                        override fun onComplete() {}
                    }
                )
        )

    }

    override fun clear() {
        eventStream.clear()
    }

}