package com.veoride.gmaptest

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

/**
 * 描述：
 *
 * author: seven
 * date: 2023/11/29 16:21
 */
class MapViewModel : ViewModel() {
//    private val api = MyService()

    // 通常配合LiveData、StateFlow这些可感知对象为界面提供状态。
    private val _uiState = MutableLiveData("")
    val uiState: LiveData<String> = _uiState

    fun reqData(param: String) {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun onStartClick(view: View) {
        print("----------onStartClick---")
        Toast.makeText(view.context, "点击Start", Toast.LENGTH_SHORT).show()

    }
}