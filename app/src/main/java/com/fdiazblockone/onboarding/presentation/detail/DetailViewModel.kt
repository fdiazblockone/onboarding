package com.fdiazblockone.onboarding.presentation.detail

import androidx.lifecycle.ViewModel
import com.fdiazblockone.onboarding.interactors.GetBlockById
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailViewModel(private val blockId: String, private val getBlockById: GetBlockById) :
    ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getBlockById()
    }

    private fun getBlockById() {
        coroutineScope.launch {
            getBlockById.invoke(blockId)
        }
    }
}