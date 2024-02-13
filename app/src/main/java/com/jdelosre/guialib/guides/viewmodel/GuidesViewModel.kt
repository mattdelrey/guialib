package com.jdelosre.guialib.guides.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdelosre.guialib.guides.usecase.GetGuidesUseCase
import com.jdelosre.guialib.network.entities.Guide
import com.jdelosre.guialib.guides.usecase.RefreshGuidesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuidesViewModel @Inject constructor(
    private val refreshGuidesUseCase: RefreshGuidesUseCase,
    private val getGuidesUseCase: GetGuidesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(GuidesUIState())
    val uiState: StateFlow<GuidesUIState> = _uiState.asStateFlow()

    init {
        bindGuides()
        refreshGuides()
    }

    private fun bindGuides() {
        viewModelScope.launch {
            getGuidesUseCase.invoke().collect { guides ->
                _uiState.update { it.copy(guides = guides) }
            }
        }
    }

    fun refreshGuides(){
        viewModelScope.launch {
            val isSuccessful = refreshGuidesUseCase.invoke()
//            // TODO if not successful then show snackbar
        }
    }
}

data class GuidesUIState(
    val guides: List<Guide> = listOf(),
)