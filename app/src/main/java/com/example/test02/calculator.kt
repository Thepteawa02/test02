package com.example.test02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class calculator : AppCompatActivity() {

    private lateinit var textView: TextView
    private var currentInput: String = ""
    private var currentOperator: String? = ""
    private var firstOperand: Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        textView = findViewById(R.id.show)

        val numberButtons = arrayOf(
            R.id.b0, R.id.b1, R.id.b2, R.id.b3, R.id.b4,
            R.id.b5, R.id.b6, R.id.b7, R.id.b8,
            R.id.b9, R.id.dot
        )

        for (buttonId in numberButtons) {
            findViewById<Button>(buttonId).setOnClickListener {
                onNumberButtonClick(it)
            }
        }

        findViewById<Button>(R.id.del).setOnClickListener {
            onDeleteButtonClick()
        }

        findViewById<Button>(R.id.clear).setOnClickListener {
            clearAll()
        }

        val operatorButtons = arrayOf(
            R.id.plus, R.id.minus, R.id.multiply, R.id.divide, R.id.mod
        )

        for (buttonId in operatorButtons) {
            findViewById<Button>(buttonId).setOnClickListener {
                onOperatorButtonClick(it)
            }
        }

        findViewById<Button>(R.id.equal).setOnClickListener {
            onEqualsButtonClick()
        }

        Log.e("cs", "Result: $currentInput")
        Log.e("cc", "Result: $currentOperator")
        Log.e("we", "Result: $textView")
        Log.e("rd", "Result: $firstOperand")

        val back : Button = findViewById(R.id.back)

        back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clearAll() {
        currentInput = "0"
        currentOperator = null
        firstOperand = null
        updateResult()
    }


    private fun onNumberButtonClick(view: View) {
        val buttonText = (view as Button).text.toString()

        if (currentInput == "0") {
            currentInput = buttonText
        } else {
            currentInput += buttonText
        }

        updateResult()
    }

    private fun onDeleteButtonClick() {
        if (currentInput.length > 1) {
            currentInput = currentInput.substring(0, currentInput.length - 1)
        } else {
            currentInput = "0"
        }
        updateResult()
    }

    private fun onOperatorButtonClick(view: View) {
        currentOperator = (view as Button).text.toString()
        firstOperand = currentInput.toDouble()
        currentInput = "0"
    }

    private fun onEqualsButtonClick() {
        if (currentOperator != null && firstOperand != null) {
            val secondOperand = currentInput.toDouble()
            val result = when (currentOperator) {
                "+" -> firstOperand!! + secondOperand
                "-" -> firstOperand!! - secondOperand
                "x" -> firstOperand!! * secondOperand
                "/" -> firstOperand!! / secondOperand
                "%" -> firstOperand!! % secondOperand
                else -> throw IllegalArgumentException("Invalid operator")
            }

            currentInput = result.toString()
            currentOperator = null
            firstOperand = null

            updateResult()
        }
    }

    private fun updateResult() {
        textView.text = currentInput
    }
}