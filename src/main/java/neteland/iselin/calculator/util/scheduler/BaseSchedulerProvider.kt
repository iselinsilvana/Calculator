package neteland.iselin.calculator.util.scheduler

import io.reactivex.Scheduler

interface BaseSchedulerProvider {

    fun getComputationScheduler(): Scheduler

    fun getUIScheduler(): Scheduler

}