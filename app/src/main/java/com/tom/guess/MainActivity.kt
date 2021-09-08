package com.tom.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.tom.guess.databinding.ActivityMainBinding
import java.lang.NumberFormatException
import java.util.*

//Controller
class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding
    val data : Int by lazy { 3 }
    val viewModel : GuessViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("MainActivity", "onCreate: secret is $secret")
        //view-binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.counterData.observe(this, androidx.lifecycle.Observer {
            binding.times.text = it.toString()
        })
        viewModel.resultData.observe(this, androidx.lifecycle.Observer {
            Log.d(TAG, "onCreate: result changed")
            if (it == GameStatus.INIT) return@Observer
            val message = when(it) {
                GameStatus.BIGGER -> "Bigger"
                GameStatus.SMALLER -> "Smaller"
                else -> "You got it"
            }
            AlertDialog.Builder(this)
                .setTitle("Result")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show()
        })
        //how to control views appearance
        binding.guessButton.setOnClickListener {
            guess()
        }
        binding.reset.setOnClickListener {
            reset()
        }
    }

    private fun guess() {
        val s = binding.number.text.toString()
        //挑戰，在使用者有輸入資料後，按鈕才 Enable
        if (s.length == 0) {
            AlertDialog.Builder(this)
                .setTitle("使用提示")
                .setMessage("請輸入1-10的數字")
                //Positive, Negative, Neutral
                .setPositiveButton("OK", null)
                .show()
        } else {
            viewModel.guess(s.toInt())
        }
    }

    fun reset() {
        Log.d("MainActivity", "reset: ")
        //作業，重完實作
    }
}