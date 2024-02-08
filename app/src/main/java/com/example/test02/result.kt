package com.example.test02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result : TextView = findViewById(R.id.result)
        val back : Button = findViewById(R.id.back)

        val score = intent
        var sumscore = intent.getIntExtra("sc", 0)

        result.text = "$sumscore"

        back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}