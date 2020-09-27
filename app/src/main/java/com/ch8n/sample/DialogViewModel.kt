package com.ch8n.sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DialogViewModel : ViewModel() {
    var dialogTitle = MutableLiveData<String>("")
    var dialogDescription = MutableLiveData<String>("")
    var confirmClickListener: () -> Unit = {}
    var dismissClickListener: () -> Unit = {}
    var cancelClickListener: () -> Unit = {}
}
