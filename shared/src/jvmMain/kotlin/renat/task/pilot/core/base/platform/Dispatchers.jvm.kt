package renat.task.pilot.core.base.platform

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.swing.Swing
import renat.task.pilot.core.base.platform.DispatcherProvider

actual val dispatcherProvider: DispatcherProvider = object : DispatcherProvider {
    override val main: CoroutineDispatcher = Dispatchers.Swing
    override val io: CoroutineDispatcher = Dispatchers.IO
    override val default: CoroutineDispatcher = Dispatchers.Default
    override val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}