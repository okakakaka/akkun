package com.example.seiya.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.seiya.myapplication.R.drawable.aki
import com.example.seiya.myapplication.R.drawable.akkun
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    val s = arrayOf("あっくん！？","あきちゃん！？")
    val i = arrayOf(akkun,aki)
    fun onButton(v: View) {
        val r = Random().nextInt(2)
        tv.text = s[r]
//        iv.setImageResource(i[r])
    }
}
