package com.tom.guess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class GuessViewModel : ViewModel() {
    companion object {
        val BIGGER = 1
        val SMALLER = -1
        val BINGO = 0
        val INIT = 9
    }
    private var counter = 0
    private var secret = Random().nextInt(10)+1
    val counterData = MutableLiveData<Int>()
    val resultData = MutableLiveData<Int>()
    init {
        counterData.value = counter
        println("secret: $secret")
        resultData.value = INIT
    }

    fun guess(num: Int) {
        var result = BINGO
        if (num > secret) {
            result = SMALLER
        } else if (num < secret) {
            result = BIGGER
        }
        counter++
        counterData.value = counter
        resultData.value = result
    }

}