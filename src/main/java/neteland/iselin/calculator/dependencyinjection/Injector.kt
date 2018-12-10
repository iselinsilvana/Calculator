package neteland.iselin.calculator.dependencyinjection

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import neteland.iselin.calculator.View.CalculatorFragment
import neteland.iselin.calculator.View.IViewContract
import neteland.iselin.calculator.data.CalculatorImpl
import neteland.iselin.calculator.data.ValidatorImpl
import neteland.iselin.calculator.domain.usecase.EvaluateExpression
import neteland.iselin.calculator.presenter.CalculatorPresenter
import neteland.iselin.calculator.util.scheduler.SchedulerProviderImpl
import neteland.iselin.calculator.viewmodel.CalculatorViewModel

class Injector(private var activity: AppCompatActivity) {

    private var validator: ValidatorImpl = ValidatorImpl
    private var calculator: CalculatorImpl = CalculatorImpl
    private var schedulerProvider: SchedulerProviderImpl = SchedulerProviderImpl


    fun providePresenter(view: CalculatorFragment): IViewContract.Presenter {
        return CalculatorPresenter(
            view,
            ViewModelProviders.of(activity).get(CalculatorViewModel::class.java),
            schedulerProvider,
            EvaluateExpression(calculator, validator, schedulerProvider)
        )
    }
}