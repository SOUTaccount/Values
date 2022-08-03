package com.example.value.presentation.screens.value

import com.example.value.core.Communication
import com.example.value.presentation.model.ValueUi
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
class ValueCommunication @Inject constructor() : Communication.Base<List<ValueUi>>() {
}