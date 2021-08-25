package com.tom.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.tom.guess.databinding.ActivityMainBinding
import java.lang.NumberFormatException
import java.util.*

//Controller
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var secret: Int = Random().nextInt(10)+1
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate: secret is $secret")
        //view-binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
            counter++
            binding.times.text = counter.toString()
            try {
                val num = s.toInt()
                Log.d("MainActivity", "num $num")
                val message = if (num > secret) {
                    "小一點"
                } else if (num < secret) {
                    "大一點"
                } else {
                    "答對了"
                }
                AlertDialog.Builder(this)
                    .setTitle("結果")
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .show()
            } catch (e: NumberFormatException) {
                //message
            }
        }
    }

    fun reset() {
        Log.d("MainActivity", "reset: ")
        //作業，重完實作
    }
}