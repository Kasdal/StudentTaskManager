package com.example.studenttaskmanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewTaskModel : ViewModel() {

    var name = MutableLiveData<String>()
    var description = MutableLiveData<String>()


}
