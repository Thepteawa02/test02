package com.example.test02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class quiz9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz9)

        val a : Button = findViewById(R.id.a)
        val b : Button = findViewById(R.id.b)
        val c : Button = findViewById(R.id.c)
        val d : Button = findViewById(R.id.d)

        val score = intent
        var sumscore = intent.getIntExtra("sc", 0)

        a.setOnClickListener {
            val intent = Intent(this, quiz10::class.java)
            startActivity(intent)
        }

        b.setOnClickListener {
            val intent = Intent(this, quiz10::class.java)
            startActivity(intent)
        }

        c.setOnClickListener {
            val intent = Intent(this, quiz10::class.java)
            sumscore += 1
            intent.putExtra("sc", sumscore)
            startActivity(intent)
        }

        d.setOnClickListener {
            val intent = Intent(this, quiz10::class.java)
            startActivity(intent)
        }
    }
}