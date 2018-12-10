package neteland.iselin.calculator.util.scheduler

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

object SchedulerProviderImpl: BaseSchedulerProvider {

    override fun getComputationScheduler(): Scheduler {
        return Schedulers.computation()
    }

    override fun getUIScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}