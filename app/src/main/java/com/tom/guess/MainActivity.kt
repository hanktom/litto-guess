package com.tom.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

//Controller
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //how to control views appearance
        val tv = findViewById<TextView>(R.id.message)
        tv.text = "Hello Kotlin!"
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            tv.text = "What?"
        }
        val reset = findViewById<Button>(R.id.reset)
        reset.setOnClickListener {
            tv.text = "Hello Kotlin!"
            button.isEnabled = false
        }
    }
}