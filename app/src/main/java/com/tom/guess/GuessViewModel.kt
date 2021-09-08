package com.tom.guess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class GuessViewModel : ViewModel() {
    private var counter = 0
    private var secret = Random().nextInt(10)+1
    val counterData = MutableLiveData<Int>()
    val resultData = MutableLiveData<GameStatus>()
    init {
        counterData.value = counter
        println("secret: $secret")
        resultData.value = GameStatus.INIT
    }

    fun guess(num: Int) {
        var result = GameStatus.BINGO
        if (num > secret) {
            result = GameStatus.SMALLER
        } else if (num < secret) {
            result = GameStatus.BIGGER
        }
        counter++
        counterData.value = counter
        resultData.value = result
    }
}

enum class GameStatus {
    INIT, BIGGER, SMALLER, BINGO
}