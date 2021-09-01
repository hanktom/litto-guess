package com.tom.guess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class GuessViewModel : ViewModel() {
    private var counter = 0
    private var secret = Random().nextInt(10)+1
    val counterData = MutableLiveData<Int>()
    init {
        counterData.value = counter
        println("secret: $secret")
    }

}