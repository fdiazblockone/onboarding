package com.fdiazblockone.onboarding.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fdiazblockone.onboarding.domain.Block
import com.fdiazblockone.onboarding.framework.network.JsonObject
import com.fdiazblockone.onboarding.interactors.GetBlocks
import com.fdiazblockone.onboarding.interactors.GetInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ListViewModel(private val getInfo: GetInfo, private val getBlocks: GetBlocks) : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _myString: MutableLiveData<String> = MutableLiveData()
    val myString: LiveData<String>
        get() = _myString

    private var _blockList: MutableLiveData<List<Block>> = MutableLiveData()
    val blockList: LiveData<List<Block>>
        get() = _blockList

    init {
        getInfo()
    }

    private fun getInfo() {
        coroutineScope.launch {
            _myString.postValue(getInfo.invoke())
        }
    }

    fun getBlocks() {
        coroutineScope.launch {
            val obj = JsonObject(myString.value.toString())
            _blockList.postValue(getBlocks.invoke(obj))
        }
    }
}