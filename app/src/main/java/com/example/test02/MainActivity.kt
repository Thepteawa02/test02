package com.example.test02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quiz: Button = findViewById(R.id.quiz)
        val cal: Button = findViewById(R.id.cal)
        val login: Button = findViewById(R.id.login)

        quiz.setOnClickListener{
            val intent = Intent(this,quiz1::class.java)
            startActivity(intent)
        }

        cal.setOnClickListener{
            val intent = Intent(this,calculator::class.java)
            startActivity(intent)
        }

        login.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }



    }
}