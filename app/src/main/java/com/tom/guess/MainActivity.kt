package com.tom.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

//Controller
class MainActivity : AppCompatActivity() {

    private val message: TextView?
        get() {
            val tv = findViewById<TextView>(R.id.message)
            return tv
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //how to control views appearance
        val guessButton = findViewById<Button>(R.id.guessButton)
//        val reset = findViewById<Button>(R.id.reset)
        guessButton.setOnClickListener {
            val s = findViewById<EditText>(R.id.number)
                .text.toString()
            //作業，在使用者有輸入資料後，按鈕才 Enable
            if (s.length == 0) {
                AlertDialog.Builder(this)
                    .setTitle("使用提示")
                    .setMessage("請輸入1-10的數字")
                        //Positive, Negative, Neutral
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                val num = s.toInt()
                Log.d("MainActivity", "num $num")
            }
        }
//        reset.setOnClickListener {
//        }
    }
    fun reset(view: View) {
        Log.d("MainActivity", "reset: ")
    }

    fun test() {

    }

}