package renat.task.pilot.core.vm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class MviViewModel<ViewState: State, ViewIntent: Intent, Reducer: ReduceAction> {
    protected val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val _state = MutableStateFlow(initialStateValue())
    val state = _state.asStateFlow()

    private val _intent = Channel<ViewIntent>()
    protected val intent = _intent.receiveAsFlow()

    private val _reducer = Channel<Reducer>()
    protected val reducer = _reducer.receiveAsFlow()

    init {
        intent.onEach(::executeIntent).launchIn(viewModelScope)

        reducer.onEach { reducerAction ->
            _state.update { reduce(it, reducerAction) }
        }.launchIn(viewModelScope)
    }

    abstract fun initialStateValue(): ViewState

    protected fun sendIntent(intent: ViewIntent) {
        viewModelScope.launch { _intent.send(intent) }
    }

    protected abstract fun executeIntent(intent: ViewIntent)

    protected abstract fun reduce(state: ViewState, reducer: Reducer): ViewState

    open fun onCleared() = Unit
}

@Composable
fun MviViewModel<*, *, *>.attach() {
    DisposableEffect(this) {
        onDispose {
            onCleared()
        }
    }
}