package renat.task.pilot.core.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import renat.task.pilot.core.platform.dispatcherProvider

abstract class MviViewModel<ViewState: State, ViewIntent: Intent, Reduce: Reducer>: ViewModel() {
    private val viewModelJob = SupervisorJob()
    protected val viewModelScope = CoroutineScope(dispatcherProvider.main + viewModelJob)

    private val _state = MutableStateFlow(initialStateValue())
    val state = _state.asStateFlow()

    private val intent = MutableSharedFlow<ViewIntent>()

    private val reducer = MutableSharedFlow<Reduce>()

    init {
        intent.onEach(::executeIntent).launchIn(viewModelScope)

        reducer.onEach { reducerAction ->
            _state.update { reduce(it, reducerAction) }
        }.launchIn(viewModelScope)
    }

    fun sendIntent(intent: ViewIntent) {
        viewModelScope.launch { this@MviViewModel.intent.emit(intent) }
    }

    abstract fun initialStateValue(): ViewState

    protected fun sendReduce(reduce: Reduce) = viewModelScope.launch { reducer.emit(reduce) }

    protected abstract fun executeIntent(intent: ViewIntent)

    protected abstract fun reduce(state: ViewState, reducer: Reduce): ViewState
}