package com.tom.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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
        val reset = findViewById<Button>(R.id.reset)
        guessButton.setOnClickListener {
            val num = findViewById<EditText>(R.id.number)
                .text.toString().toInt()
            println(num)
        }
        reset.setOnClickListener {
        }
    }

    fun test() {

    }

}