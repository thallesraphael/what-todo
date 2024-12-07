package com.heimdall.whattodo.ui

sealed interface UIEvent {
    data class ShowMessage(val message: String) : UIEvent
    data object NavigateBack : UIEvent
    data class Navigate<T : Any>(val route: T) : UIEvent

}