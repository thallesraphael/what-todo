package com.heimdall.whattodo.ui.feature.addedit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heimdall.whattodo.data.TaskRepository
import com.heimdall.whattodo.ui.UIEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AddEditViewModel(
    private val repository: TaskRepository
) : ViewModel() {

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf<String?>(null)
        private set

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: AddEditEvent) {

        when(event) {
            is AddEditEvent.TitleChanged -> {
                title = event.title
            }
            is AddEditEvent.DescriptionChanged -> {
                description = event.description
            }
            AddEditEvent.Save -> TODO()
        }
    }

    fun saveTask() {
        viewModelScope.launch {

            if (title.isBlank()) {
                _uiEvent.send(UIEvent.ShowMessage("Title cannot be empty"))
            }

            repository.insert(title, description)
        }
    }
}