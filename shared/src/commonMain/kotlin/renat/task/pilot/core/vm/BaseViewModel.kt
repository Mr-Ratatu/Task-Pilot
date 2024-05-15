package renat.task.pilot.core.vm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel <State: BaseEventState, Event: BaseEvent> {
    protected val viewModelScope = CoroutineScope(SupervisorJob())

    private val _state = MutableStateFlow(initState())
    val state = _state.asStateFlow()

    private val _event = Channel<Event>()
    val event = _event.receiveAsFlow()

    protected fun updateState(state: State) = _state.update { state }

    protected fun sendEvent(event: Event) {
        viewModelScope.launch { _event.send(event) }
    }

    fun onDestroy() {
        viewModelScope.cancel()
        onCleared()
    }

    open fun onCleared() = Unit

    abstract fun initState() : State
}