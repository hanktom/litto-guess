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

//Controller
class MainActivity : AppCompatActivity() {

    private val message: TextView?
        get() {
            val tv = findViewById<TextView>(R.id.message)
            return tv
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view-binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //how to control views appearance
        binding.guessButton.setOnClickListener {
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
                try {
                    val num = s.toInt()
                    Log.d("MainActivity", "num $num")
                } catch(e: NumberFormatException) {
                    //message
                }
            }
        }
        /*binding.reset.setOnClickListener {

        }*/
//        reset.setOnClickListener {
//        }
    }
    fun reset(view: View) {
        Log.d("MainActivity", "reset: ")
    }

    fun test() {

    }

}